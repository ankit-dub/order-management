package com.example.ordermanagement.service;

import com.example.ordermanagement.entity.User;
import com.example.ordermanagement.helper.UserDetailsMapper;
import com.example.ordermanagement.model.UserDetail;
import com.example.ordermanagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not present", email)));
    }

    public UserDetail addUser(UserDetail userDetail) {
        boolean userExists = userRepository.findByEmail(userDetail.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(userDetail.getPassword());
        userDetail.setPassword(encodedPassword);

        userRepository.save(new User(userDetail.getFirstName(), userDetail.getLastName(), userDetail.getEmail(), userDetail.getPassword(), userDetail.getDesignation(), userDetail.getPhone(), userDetail.getRole()));

        return userDetail;
    }

    public UserDetail updateUser(UserDetail userDetail, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id not present"));
        user.setFirstName(userDetail.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setDesignation(user.getDesignation());
        user.setPhone(user.getPhone());
        user.setRole(user.getRole());
        userRepository.save(user);
        return userDetail;
    }

    public List<UserDetail> fetchAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserDetailsMapper::userDetailsToDto)
                .collect(Collectors.toList());
    }

    public UserDetail fetchUserById(Long id) {
        return UserDetailsMapper.userDetailsToDto(
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new UsernameNotFoundException("User not present")));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}

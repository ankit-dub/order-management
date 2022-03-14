package com.example.ordermanagement.helper;

import com.example.ordermanagement.entity.User;
import com.example.ordermanagement.model.UserDetail;

public class UserDetailsMapper {
    public static UserDetail userDetailsToDto(User user) {
        return UserDetail.builder()
                .role(user.getRole())
                .phone(user.getPhone())
                .designation(user.getDesignation())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}

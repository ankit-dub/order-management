package com.example.ordermanagement.controller;

import com.example.ordermanagement.enums.UserRole;
import com.example.ordermanagement.model.UserDetail;
import com.example.ordermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/admin-registration")
    public ResponseEntity<UserDetail> registerUser(@Valid @RequestBody UserDetail request) {
        if (request.getRole().equals(UserRole.USER)) {
            throw new IllegalStateException("Only admin can register");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(request));
    }

    @PostMapping("/registration")
    public ResponseEntity<UserDetail> addUser(@Valid @RequestBody UserDetail request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDetail> updateUser(@Valid @RequestBody UserDetail updateRequest, @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(updateRequest, id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDetail>> fetchAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetail> fetchUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchUserById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}

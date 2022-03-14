package com.example.ordermanagement.model;

import com.example.ordermanagement.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    @Size(min = 3, max = 30)
    private String firstName;
    private String lastName;
    private String designation;
    @Email
    private String email;
    private String phone;
    private String password;
    private UserRole role;
}

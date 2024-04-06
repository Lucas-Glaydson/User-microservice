package com.user.microservice.usermicroservice.dtos.register;

import com.user.microservice.usermicroservice.role.UserRole;

public record RegisterRequestDTO(String firstName, String lastName, String email, String password, UserRole role) {

}

package com.user.microservice.usermicroservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequestDTO(
        @NotBlank
        String owner,
        @NotBlank @Email
        String emailFrom,
        @NotBlank @Email
        String emailTo,
        @NotBlank
        String subject,
        @NotBlank
        String text
) {
}

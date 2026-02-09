package com.youtube.learningSpringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Singular;

@Data
public class AddStudentRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min=3,max = 30,message = "The name must be between 3 to 30 words")
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    private String email;
}

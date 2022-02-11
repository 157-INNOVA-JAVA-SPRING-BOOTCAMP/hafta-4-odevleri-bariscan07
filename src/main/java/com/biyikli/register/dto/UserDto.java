package com.biyikli.register.dto;

import com.biyikli.register.validation.PasswordMatch;
import com.biyikli.register.validation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

// Boiler plate kod için lombok anotasyonu
@Data
// password - confirm password alanlarına
// girilen değerlerin aynı olup olmadığını
// kontrol eden custom anotasyon.
@PasswordMatch
public class UserDto {

    // İsim alanı. Boş olamaz.
    @NotEmpty(message = "Full name is required")
    private String name;

    // email alanı. Boş olamaz.
    @NotEmpty(message = "email is required")
    // Kayıt sürecinde verilen email'in valid
    // olup olmadığını kontrol eden bir başka
    // custom anotasyon
    @ValidEmail
    private String email;

    // password - confirm password alanları. Boş olamaz.
    @NotEmpty(message = "Password is required")
    private String password;
    private String matchingPassword;

}

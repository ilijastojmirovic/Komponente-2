package com.example.userserivsapp.UserServisApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ClientCreateDto {

    private Long id;
    private String uniqeCardNumber;
    private int nubmerOfTrainings;
    private UserDto userDto;


    @Getter
    @Setter
    public static class UserDto {

        @NotBlank
        private String username;
        @Length(min = 8, max = 20)
        private String password;
        @NotBlank
        private String email;
        private String dateOfBirth;

        private String firstName;
        private String lastName;
    }
}

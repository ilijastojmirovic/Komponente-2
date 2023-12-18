package com.example.userserivsapp.UserServisApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UpdateClientDto {


    private String uniqeCardNumber;
    private UserDto userDto;


    @Getter
    @Setter
    public static class UserDto {

        private String username;
        @Length(min = 5, max = 20)
        //private String password;
        private String email;
        private String firstName;
        private String lastName;

    }
}

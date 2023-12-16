package com.example.userserivsapp.UserServisApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String uniqeCardNumber;
    private int nubmerOfTrainings;

    public ClientDto(Long id, String username, String email, String firstName, String lastName, String uniqeCardNumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uniqeCardNumber = uniqeCardNumber;
    }
}

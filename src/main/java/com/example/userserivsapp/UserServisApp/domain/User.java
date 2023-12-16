package com.example.userserivsapp.UserServisApp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class User {

    private String username;
    private String password;
    private String email;
    private String dateOfBirth;
    private String firstName;
    private String lastName;

    //public User() {
    //}

    public User(String username, String password, String email, String dateOfBirth, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

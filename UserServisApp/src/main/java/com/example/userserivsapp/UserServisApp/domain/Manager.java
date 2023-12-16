package com.example.userserivsapp.UserServisApp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "username", unique = true)
})
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hallName;
    private String startDate;

    @Embedded
    private User user;
}

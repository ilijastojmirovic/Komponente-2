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

    public Manager(Long id, String hallName, String startDate, User user) {
        this.id = id;
        this.hallName = hallName;
        this.startDate = startDate;
        this.user = user;
    }

    public Manager() {

    }
}

package com.example.userserivsapp.UserServisApp.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(columnList = "uniqueCardNumber", unique = true),
        @Index(columnList = "email", unique = true),
        @Index(columnList = "username", unique = true)
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uniqeCardNumber;
    private int nubmerOfTrainings;

    @Embedded
    private User user;

    public Client(Long id, String uniqeCardNumber, int nubmerOfTrainings, User user) {
        this.id = id;
        this.uniqeCardNumber = uniqeCardNumber;
        this.nubmerOfTrainings = nubmerOfTrainings;
        this.user = user;
    }
}

package com.example.userserivsapp.UserServisApp.repository;

import com.example.userserivsapp.UserServisApp.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    //Optional<Client> findUserByUsernameAndPassword(String username, String password);
    Optional<Client> findByUser_EmailAndUser_Password(String email, String password);
    Optional<Client> findByUser_EmailAndUser_Username(String email, String password);
    Optional<Client> findByuniqueCardNumber(String uniqueCardNumber);

}

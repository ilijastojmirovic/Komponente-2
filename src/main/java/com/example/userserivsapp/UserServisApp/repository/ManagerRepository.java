package com.example.userserivsapp.UserServisApp.repository;

import com.example.userserivsapp.UserServisApp.domain.Client;
import com.example.userserivsapp.UserServisApp.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional<Manager> findByUser_EmailAndUser_Password(String email, String password);

    Optional<Manager> findByUser_EmailAndUser_Username(String email, String password);
}

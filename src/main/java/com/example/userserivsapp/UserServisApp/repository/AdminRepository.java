package com.example.userserivsapp.UserServisApp.repository;

import com.example.userserivsapp.UserServisApp.domain.Admin;
import com.example.userserivsapp.UserServisApp.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUser_EmailAndUser_Password(String email, String password);
}


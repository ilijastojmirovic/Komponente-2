package com.example.userserivsapp.UserServisApp.repository;

import com.example.userserivsapp.UserServisApp.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

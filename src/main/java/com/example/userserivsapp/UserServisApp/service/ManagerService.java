package com.example.userserivsapp.UserServisApp.service;

import com.example.userserivsapp.UserServisApp.dto.ManagerCreateDto;
import com.example.userserivsapp.UserServisApp.dto.ManagerDto;
import com.example.userserivsapp.UserServisApp.dto.TokenRequestDto;
import com.example.userserivsapp.UserServisApp.dto.TokenResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService {
    Page<ManagerDto> findAll(Pageable pageable);

    ManagerDto add(ManagerCreateDto managerCreateDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);
}

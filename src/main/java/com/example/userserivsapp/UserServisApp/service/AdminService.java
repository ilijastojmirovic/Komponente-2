package com.example.userserivsapp.UserServisApp.service;

import com.example.userserivsapp.UserServisApp.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {

    Page<ClientDto> findAllClients(Pageable pageable);

    Page<ManagerDto> findAllManageres(Pageable pageable);

    ClientDto updatePermissionClient(UpdatePermissionDto updatePermissionDto);

    ManagerDto updatePermissionManager(UpdatePermissionDto updatePermissionDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);
    //login
}

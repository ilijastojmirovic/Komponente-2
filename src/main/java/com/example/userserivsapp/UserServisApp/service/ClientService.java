package com.example.userserivsapp.UserServisApp.service;

import com.example.userserivsapp.UserServisApp.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    Page<ClientDto> findAll(Pageable pageable);

    ClientDto add(ClientCreateDto clientCreateDto);

    ClientDto update(UpdateClientDto updateClientDto);

    ClientDto updatePassword(UpdatePasswordDto updatePasswordDto);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);
}

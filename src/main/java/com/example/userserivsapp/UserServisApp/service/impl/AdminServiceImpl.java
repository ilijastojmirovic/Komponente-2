package com.example.userserivsapp.UserServisApp.service.impl;

import com.example.userserivsapp.UserServisApp.domain.Client;
import com.example.userserivsapp.UserServisApp.domain.Manager;
import com.example.userserivsapp.UserServisApp.dto.*;
import com.example.userserivsapp.UserServisApp.mapper.ClientMapper;
import com.example.userserivsapp.UserServisApp.mapper.ManagerMapper;
import com.example.userserivsapp.UserServisApp.repository.AdminRepository;
import com.example.userserivsapp.UserServisApp.repository.ClientRepository;
import com.example.userserivsapp.UserServisApp.repository.ManagerRepository;
import com.example.userserivsapp.UserServisApp.secutiry.service.TokenService;
import com.example.userserivsapp.UserServisApp.service.AdminService;
import io.jsonwebtoken.io.IOException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private TokenService tokenService;
    private AdminRepository adminRepository;
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;
    private ManagerRepository managerRepository;
    private ManagerMapper managerMapper;

    public AdminServiceImpl(TokenService tokenService, AdminRepository adminRepository, ClientRepository clientRepository, ClientMapper clientMapper, ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.tokenService = tokenService;
        this.adminRepository = adminRepository;
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Override
    public Page<ClientDto> findAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(clientMapper::clientToClientDto);
    }

    @Override
    public Page<ManagerDto> findAllManageres(Pageable pageable) {
        return managerRepository.findAll(pageable)
                .map(managerMapper::managerToManagerDto);
    }

    @Override
    public ClientDto updatePermissionClient(UpdatePermissionDto updatePermissionDto) {
        Client client = clientRepository.findByUser_EmailAndUser_Username(updatePermissionDto.getEmail(),updatePermissionDto.getUsername()).get();
        if(client == null){
            return null;
        }
        client =  clientMapper.updatePermissionDtoToClient(client,updatePermissionDto);
        client = clientRepository.save(client);
        return clientMapper.clientToClientDto(client);
    }

    @Override
    public ManagerDto updatePermissionManager(UpdatePermissionDto updatePermissionDto) {
        Manager manager = managerRepository.findByUser_EmailAndUser_Username(updatePermissionDto.getEmail(),updatePermissionDto.getUsername()).get();
        if(manager == null){
            return null;
        }
        manager = managerMapper.updatePermissionDtoToManager(manager,updatePermissionDto);
        manager = managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }


    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        return null;
    }
}

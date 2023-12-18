package com.example.userserivsapp.UserServisApp.service.impl;

import com.example.userserivsapp.UserServisApp.domain.Client;
import com.example.userserivsapp.UserServisApp.domain.Manager;
import com.example.userserivsapp.UserServisApp.dto.ManagerCreateDto;
import com.example.userserivsapp.UserServisApp.dto.ManagerDto;
import com.example.userserivsapp.UserServisApp.dto.TokenRequestDto;
import com.example.userserivsapp.UserServisApp.dto.TokenResponseDto;
import com.example.userserivsapp.UserServisApp.mapper.ManagerMapper;
import com.example.userserivsapp.UserServisApp.repository.ManagerRepository;
import com.example.userserivsapp.UserServisApp.secutiry.service.TokenService;
import com.example.userserivsapp.UserServisApp.service.ManagerService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    private TokenService tokenService;
    private ManagerRepository managerRepository;
    private ManagerMapper managerMapper;

    public ManagerServiceImpl(TokenService tokenService, ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.tokenService = tokenService;
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Override
    public Page<ManagerDto> findAll(Pageable pageable) {
        return managerRepository.findAll(pageable)
                .map(managerMapper::managerToManagerDto);
    }

    @Override
    public ManagerDto add(ManagerCreateDto managerCreateDto) {
        Manager manager = managerMapper.managerCreateDtoToManager(managerCreateDto);
        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        Manager user = null;
        try {
            user = managerRepository
                    .findByUser_EmailAndUser_Password(tokenRequestDto.getEmail(), tokenRequestDto.getPassword())
                    .orElseThrow(() -> new NotFoundException(String
                            .format("User with username: %s and password: %s not found.", tokenRequestDto.getEmail(),
                                    tokenRequestDto.getPassword())));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("class", user.getClass().getName());
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
    }
}

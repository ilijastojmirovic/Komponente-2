package com.example.userserivsapp.UserServisApp.controller;


import com.example.userserivsapp.UserServisApp.dto.TokenRequestDto;
import com.example.userserivsapp.UserServisApp.dto.TokenResponseDto;
import com.example.userserivsapp.UserServisApp.service.AdminService;
import com.example.userserivsapp.UserServisApp.service.ClientService;
import com.example.userserivsapp.UserServisApp.service.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private AdminService adminService;
    private ClientService clientService;
    private ManagerService managerService;

    public UserController(AdminService adminService, ClientService clientService, ManagerService managerService) {
        this.adminService = adminService;
        this.clientService = clientService;
        this.managerService = managerService;
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
        TokenResponseDto tokenResponseDto = clientService.login(tokenRequestDto);
        
        if(tokenResponseDto != null)
            return  new ResponseEntity<>(tokenResponseDto, HttpStatus.OK);

        tokenResponseDto = managerService.login(tokenRequestDto);
        if(tokenResponseDto != null)
            return  new ResponseEntity<>(tokenResponseDto, HttpStatus.OK);

        tokenResponseDto = adminService.login(tokenRequestDto);
        return  new ResponseEntity<>(tokenResponseDto, HttpStatus.OK);

    }
}

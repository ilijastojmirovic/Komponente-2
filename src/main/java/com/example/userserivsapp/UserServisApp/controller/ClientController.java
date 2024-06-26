package com.example.userserivsapp.UserServisApp.controller;


import com.example.userserivsapp.UserServisApp.domain.Client;
import com.example.userserivsapp.UserServisApp.dto.*;
import com.example.userserivsapp.UserServisApp.secutiry.CheckSecurity;
import com.example.userserivsapp.UserServisApp.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @Operation(summary = "Get all users")
    @GetMapping
    //@CheckSecurity(classTypes = {"Client"})
    public ResponseEntity<Page<ClientDto>> getAllUsers(//@RequestHeader("Authorization") String authorization,
                                                       Pageable pageable) {

        return new ResponseEntity<>(clientService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Register user")
    @PostMapping
    public ResponseEntity<ClientDto> saveUser(@RequestBody @Valid ClientCreateDto clientCreateDto) {
        return new ResponseEntity<>(clientService.add(clientCreateDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(clientService.login(tokenRequestDto), HttpStatus.OK);
    }

    @Operation(summary = "Update client")
    @PutMapping("/update")
    public ResponseEntity<ClientDto> updateClient(@RequestBody UpdateClientDto updateClientDto) {
        return new ResponseEntity<>(clientService.update(updateClientDto), HttpStatus.OK);
    }

    @Operation(summary = "Update clients password")
    @PutMapping("/updatepassword")
    public ResponseEntity<ClientDto> updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto) {
        return new ResponseEntity<>(clientService.updatePassword(updatePasswordDto), HttpStatus.OK);
    }
    //fali login
}

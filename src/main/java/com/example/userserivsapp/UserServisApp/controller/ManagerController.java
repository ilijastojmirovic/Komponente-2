package com.example.userserivsapp.UserServisApp.controller;

import com.example.userserivsapp.UserServisApp.domain.Manager;
import com.example.userserivsapp.UserServisApp.dto.ClientCreateDto;
import com.example.userserivsapp.UserServisApp.dto.ClientDto;
import com.example.userserivsapp.UserServisApp.dto.ManagerCreateDto;
import com.example.userserivsapp.UserServisApp.dto.ManagerDto;
import com.example.userserivsapp.UserServisApp.service.ClientService;
import com.example.userserivsapp.UserServisApp.service.ManagerService;
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
@RequestMapping("/manager")
public class ManagerController {
    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<Page<ManagerDto>> getAllUsers(//@RequestHeader("Authorization") String authorization,
                                                        Pageable pageable) {

        return new ResponseEntity<>(managerService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Register user")
    @PostMapping
    public ResponseEntity<ManagerDto> saveUser(@RequestBody @Valid ManagerCreateDto managerCreateDto) {
        return new ResponseEntity<>(managerService.add(managerCreateDto), HttpStatus.CREATED);
    }

    //fali login
}

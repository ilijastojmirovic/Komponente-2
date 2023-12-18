package com.example.userserivsapp.UserServisApp.controller;

import com.example.userserivsapp.UserServisApp.dto.ClientCreateDto;
import com.example.userserivsapp.UserServisApp.dto.ClientDto;
import com.example.userserivsapp.UserServisApp.dto.ManagerDto;
import com.example.userserivsapp.UserServisApp.dto.UpdatePermissionDto;
import com.example.userserivsapp.UserServisApp.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Operation(summary = "Get all clients")
    @GetMapping("/clients")
    //@CheckSecurity(classTypes = {"Client"})
    public ResponseEntity<Page<ClientDto>> getAllClients(//@RequestHeader("Authorization") String authorization,
                                                       Pageable pageable) {

        return new ResponseEntity<>(adminService.findAllClients(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Get all clients")
    @GetMapping("/managers")
    //@CheckSecurity(classTypes = {"Client"})
    public ResponseEntity<Page<ManagerDto>> getAllManagers(//@RequestHeader("Authorization") String authorization,
                                                          Pageable pageable) {

        return new ResponseEntity<>(adminService.findAllManageres(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Change client permission")
    @PutMapping("/changeclient")
    public ResponseEntity<ClientDto> updateClientPermission(@RequestBody UpdatePermissionDto updatePermissionDto) {
        return new ResponseEntity<>(adminService.updatePermissionClient(updatePermissionDto), HttpStatus.OK);
    }

    @Operation(summary = "Change manager permission")
    @PutMapping("/changemanager")
    public ResponseEntity<ManagerDto> updateManagerPermission(@RequestBody UpdatePermissionDto updatePermissionDto) {
        return new ResponseEntity<>(adminService.updatePermissionManager(updatePermissionDto), HttpStatus.OK);
    }

    /* ce ima ovako nesto za login za admina
    @ApiOperation(value = "Login")
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }
     */
}

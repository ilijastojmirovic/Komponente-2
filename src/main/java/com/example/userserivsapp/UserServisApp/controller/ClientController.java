package com.example.userserivsapp.UserServisApp.controller;


import com.example.userserivsapp.UserServisApp.dto.ClientCreateDto;
import com.example.userserivsapp.UserServisApp.dto.ClientDto;
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


    @Operation(summary = "Get all users")/*,
            description = "Get a list of all users",
            responses = {
                    @ApiResponse(description = "Successful Operation", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    // Dodajte ostale odgovore po potrebi
            })*/
    @GetMapping
    public ResponseEntity<Page<ClientDto>> getAllUsers(
                                                       Pageable pageable) {

        return new ResponseEntity<>(clientService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Register user")
    @PostMapping
    public ResponseEntity<ClientDto> saveUser(@RequestBody @Valid ClientCreateDto clientCreateDto) {
        return new ResponseEntity<>(clientService.add(clientCreateDto), HttpStatus.CREATED);
    }

    //fali login
}

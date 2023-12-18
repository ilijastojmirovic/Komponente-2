package com.example.userserivsapp.UserServisApp.mapper;

import com.example.userserivsapp.UserServisApp.domain.Client;
import com.example.userserivsapp.UserServisApp.domain.User;
import com.example.userserivsapp.UserServisApp.dto.*;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDto clientToClientDto(Client client){
       return new ClientDto(client.getId(),client.getUser().getUsername(),client.getUser().getEmail(),client.getUser().getFirstName(),
                client.getUser().getLastName(),client.getUniqeCardNumber());
    }

    public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto){
        User user = new User(clientCreateDto.getUserDto().getUsername(),clientCreateDto.getUserDto().getPassword(),clientCreateDto.getUserDto().getEmail(),
                clientCreateDto.getUserDto().getDateOfBirth(),clientCreateDto.getUserDto().getFirstName(),clientCreateDto.getUserDto().getLastName(),clientCreateDto.getUserDto().isPermission());
        return new Client(clientCreateDto.getId(),clientCreateDto.getUniqeCardNumber(),clientCreateDto.getNubmerOfTrainings(),user);
    }

    public Client updatePermissionDtoToClient(Client client, UpdatePermissionDto updatePermissionDto){
        client.getUser().setPermission(updatePermissionDto.isPermission());
        return client;
    }

    public Client updateClientDtoToClient(Client client, UpdateClientDto updateClientDto){
        client.getUser().setUsername(updateClientDto.getUserDto().getUsername());
        client.getUser().setFirstName(updateClientDto.getUserDto().getFirstName());
        client.getUser().setEmail(updateClientDto.getUserDto().getEmail());
        client.getUser().setLastName(updateClientDto.getUserDto().getLastName());
        return client;
    }

    public Client updatePassword(Client client, UpdatePasswordDto updatePasswordDto){
        client.getUser().setPassword(updatePasswordDto.getPassword());
        return client;
    }
}

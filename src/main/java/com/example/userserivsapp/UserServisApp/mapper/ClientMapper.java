package com.example.userserivsapp.UserServisApp.mapper;

import com.example.userserivsapp.UserServisApp.domain.Client;
import com.example.userserivsapp.UserServisApp.domain.User;
import com.example.userserivsapp.UserServisApp.dto.ClientCreateDto;
import com.example.userserivsapp.UserServisApp.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDto clientToClientDto(Client client){
       return new ClientDto(client.getId(),client.getUser().getUsername(),client.getUser().getEmail(),client.getUser().getFirstName(),
                client.getUser().getLastName(),client.getUniqeCardNumber());
    }

    public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto){
        User user = new User(clientCreateDto.getUserDto().getUsername(),clientCreateDto.getUserDto().getPassword(),clientCreateDto.getUserDto().getEmail(),
                clientCreateDto.getUserDto().getDateOfBirth(),clientCreateDto.getUserDto().getFirstName(),clientCreateDto.getUserDto().getLastName());
        return new Client(clientCreateDto.getId(),clientCreateDto.getUniqeCardNumber(),clientCreateDto.getNubmerOfTrainings(),user);
    }
}

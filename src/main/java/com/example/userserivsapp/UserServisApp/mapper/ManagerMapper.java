package com.example.userserivsapp.UserServisApp.mapper;

import com.example.userserivsapp.UserServisApp.domain.Client;
import com.example.userserivsapp.UserServisApp.domain.Manager;
import com.example.userserivsapp.UserServisApp.domain.User;
import com.example.userserivsapp.UserServisApp.dto.ManagerCreateDto;
import com.example.userserivsapp.UserServisApp.dto.ManagerDto;
import com.example.userserivsapp.UserServisApp.dto.UpdatePermissionDto;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    public ManagerDto managerToManagerDto(Manager manager){
        return new ManagerDto(manager.getId(), manager.getHallName(), manager.getUser().getUsername(),
                manager.getUser().getEmail(),manager.getUser().getFirstName(),manager.getUser().getLastName());
    }

    public Manager managerCreateDtoToManager(ManagerCreateDto managerCreateDto){
        User user = new User(managerCreateDto.getUserDto().getUsername(),managerCreateDto.getUserDto().getPassword(),managerCreateDto.getUserDto().getEmail(),
                managerCreateDto.getUserDto().getDateOfBirth(),managerCreateDto.getUserDto().getFirstName(),managerCreateDto.getUserDto().getLastName(),managerCreateDto.getUserDto().isPermission());
        return new Manager(managerCreateDto.getId(),managerCreateDto.getHallName(),managerCreateDto.getStartDate(),user);
    }

    public Manager updatePermissionDtoToManager(Manager manager, UpdatePermissionDto updatePermissionDto){
        manager.getUser().setPermission(updatePermissionDto.isPermission());
        return manager;
    }

}

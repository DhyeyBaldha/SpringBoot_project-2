package com.example.SpringBoot_project_2.service;

import com.example.SpringBoot_project_2.DTO.UserDto;
import com.example.SpringBoot_project_2.entity.Users;
import com.example.SpringBoot_project_2.exceptions.*;
import com.example.SpringBoot_project_2.repository.UserRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    public UserDto createuser(UserDto userDto){
        Users user=this.dtoToUser(userDto);
        Users saveuser=this.userRepo.save(user);
        return this.userToDto(saveuser);
    }
    public UserDto

    updateuser(UserDto userDto ,Integer id){
        Users user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user","id",id));
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        Users updateuser=this.userRepo.save(user);
        return this.userToDto(updateuser);
    }
    public UserDto getuserbyid(int id){
        Users user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user","id",id));
        return this.userToDto(user);
    }
    public List<UserDto> getalluser(){
        List<Users> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;

    }
    public void deleteUser(int id){
        Users user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user","id",id));
        this.userRepo.delete(user);
    }
    private Users dtoToUser(UserDto userDto){
        return new Users().setId(userDto.getId()).setName(userDto.getName())
                .setEmail(userDto.getEmail()).setPassword(userDto.getPassword()).setAbout(userDto.getAbout());
    }
    private UserDto userToDto(Users users){
        return new UserDto().setId(users.getId()).setName(users.getName())
                .setEmail(users.getEmail()).setPassword(users.getPassword()).setAbout(users.getAbout());
    }
}

package com.example.SpringBoot_project_2.controller;

import com.example.SpringBoot_project_2.DTO.ApiResponce;
import com.example.SpringBoot_project_2.DTO.UserDto;
import com.example.SpringBoot_project_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseEntity<UserDto> creareuser(@RequestBody UserDto userDto){
        UserDto createuserdto=this.userService.createuser(userDto);
        return new ResponseEntity<>(createuserdto, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateuser(@RequestBody UserDto userDto,@PathVariable("id") Integer id){
        UserDto updateuser=this.userService.updateuser(userDto,id);
        return ResponseEntity.ok(updateuser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponce> deleteuser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<ApiResponce>(new ApiResponce("user deleted successfully",true),HttpStatus.OK);
    }
    @GetMapping("/alluser")
    public ResponseEntity<List<UserDto>> getalluser(){
        return ResponseEntity.ok(this.userService.getalluser());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getbyid(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.userService.getuserbyid(id));
    }
}

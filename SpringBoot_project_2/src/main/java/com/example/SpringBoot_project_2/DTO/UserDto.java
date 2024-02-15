package com.example.SpringBoot_project_2.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private String about;
}

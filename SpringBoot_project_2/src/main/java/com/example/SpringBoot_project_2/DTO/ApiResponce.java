package com.example.SpringBoot_project_2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor
public class ApiResponce {
    private String massage;
    private Boolean success;
}

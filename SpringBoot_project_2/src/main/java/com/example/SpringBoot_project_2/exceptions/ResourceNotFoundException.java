package com.example.SpringBoot_project_2.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String resourcename;
    String fieldname;
    long fildvalue;

    public ResourceNotFoundException(String resourcename,String fieldname,long fildvalue) {
        super(String.format("%s not found with %s : %l",resourcename,fieldname,fildvalue));
        this.fieldname = fieldname;
        this.resourcename= resourcename;
        this.fildvalue= fildvalue;
    }
}

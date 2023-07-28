package com.example.yajp.userdto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class UsersDTO {


    private String name;
    private String email;
}

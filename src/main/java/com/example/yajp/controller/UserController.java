package com.example.yajp.controller;


import com.example.yajp.domain.Users;
import com.example.yajp.service.UserService;
import com.example.yajp.userdto.UsersDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    UserService userService;

    @GetMapping
    public List<Users> allUsers() {
        log.debug("allUsers");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") Long id) {
        return userService.findById(id).get();
    }


    @PostMapping()
    public Users saveUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/list")
    public List<UsersDTO> listUsers() {
        return userService.
                getAllUsers()
                .stream()
                .map(user -> new UsersDTO(user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

}

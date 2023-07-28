package com.example.yajp.service;


import com.example.yajp.domain.Users;
import com.example.yajp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Data
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;


    public List<Users> getAllUsers (){
        return userRepository.findAll();
    }

    public Users saveUser (Users user){
        return userRepository.save(user);
    }

    public Optional<Users> findById(Long id){
      return  userRepository.findById(id);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);

    }

}

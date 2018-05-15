package com.fys.controller;

import com.fys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /*@RequestMapping("/")
    public String findUserById(Integer id) {
        User user = userRepository.findUserById(id);
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username);
        System.out.println(password);
        return " ";
    }*/
}

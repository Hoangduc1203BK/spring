package com.example.user.presentor.controller;

import com.example.user.presentor.dto.CreateUserDto;
import com.example.user.presentor.dto.GetUserDto;
import com.example.user.presentor.model.UserModel;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.user.persistence.entity.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired
    public  UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserModel> listUser() {
        return userService.listUser();
    }
    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable("id") Integer id) {
        GetUserDto params = new GetUserDto();
        params.setId(id);
        UserModel result = userService.getUser(params);

        return result;
    }

    @PostMapping("")
    public UserModel createUser(@RequestBody CreateUserDto data) {
        UserModel result = userService.createUser(data);
        return result;
    }


}

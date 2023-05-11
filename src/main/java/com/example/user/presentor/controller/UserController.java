package com.example.user.presentor.controller;

import com.example.user.common.BussinessException;
import com.example.user.common.validator.Validator;
import com.example.user.presentor.dto.CreateUserDto;
import com.example.user.presentor.dto.GetUserDto;
import com.example.user.presentor.dto.ListUserDto;
import com.example.user.presentor.model.UserModel;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
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
    public List<UserModel> listUser(
            @RequestParam(value = "page", required = false, defaultValue = "1") String page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") String limit
    ) {
        ListUserDto listUserDto = new ListUserDto();
        listUserDto.setPage(Integer.parseInt(page));
        listUserDto.setLimit(Integer.parseInt(limit)
        );
        return userService.listUser(listUserDto);
    }

    @GetMapping("/user-infor")
    public UserModel userInfor(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber
    ) {
        GetUserDto getUserDto = new GetUserDto();
        getUserDto.setEmail(email);
        getUserDto.setPhoneNumber(phoneNumber);
        UserModel user = userService.getUserInfor(getUserDto);

        return user;
    }
    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable("id") Integer id) {
        GetUserDto params = new GetUserDto();
        params.setId(id);
        UserModel result = userService.getUser(params);

        return result;
    }

    @PostMapping("")
    public UserModel createUser(@RequestBody @Valid CreateUserDto data) {
        UserModel result = userService.createUser(data);
        return result;
    }


}

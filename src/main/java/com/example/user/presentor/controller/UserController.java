package com.example.user.presentor.controller;

import com.example.user.presentor.dto.APIResponse;
import com.example.user.presentor.dto.CreateUserDto;
import com.example.user.presentor.dto.GetUserDto;
import com.example.user.presentor.dto.ListUserDto;
import com.example.user.presentor.dto.model.UserModel;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public APIResponse listUser(
            @RequestParam(value = "page", required = false, defaultValue = "1") String page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") String limit
    ) {
        ListUserDto listUserDto = new ListUserDto();
        listUserDto.setPage(Integer.parseInt(page));
        listUserDto.setLimit(Integer.parseInt(limit)
        );
        return new APIResponse("success", "success", userService.listUser(listUserDto));
    }

    @GetMapping("/user-infor")
    public APIResponse userInfor(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber
    ) {
        GetUserDto getUserDto = new GetUserDto();
        getUserDto.setEmail(email);
        getUserDto.setPhoneNumber(phoneNumber);
        UserModel user = userService.getUserInfor(getUserDto);

        return new APIResponse("success", "success",user);
    }
    @GetMapping("/{id}")
    public APIResponse getUser(@PathVariable("id") Integer id) {
        GetUserDto params = new GetUserDto();
        params.setId(id);
        UserModel result = userService.getUser(params);

        return new APIResponse("success", "success",result);
    }

    @PostMapping("")
    public APIResponse createUser(@RequestBody @Valid CreateUserDto data) {
        UserModel result = userService.createUser(data);
        return new APIResponse("success", "success",result);
    }
}

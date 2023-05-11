package com.example.user;

import com.example.user.common.error.UserError;
import com.example.user.persistence.entity.User;
import com.example.user.persistence.repository.UserRepository;
import com.example.user.presentor.dto.CreateUserDto;
import com.example.user.presentor.dto.model.UserModel;
import com.example.user.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepos;
    private UserService userService;

    @Before
    public void SetUp(){
        userService = new UserService(userRepos);
    }

    @Test
    public void createUser_WhenEmailExist() {
        CreateUserDto userDto = new CreateUserDto(
                "hmduc",
                "duc2.hmbk@gmail.com",
                "0917462918",
                "123",
                9999999981L
        );
        Mockito.when(userService.createUser(userDto)).thenThrow(new UserError.EmailExist("duc2.hmbk@gmail.com"));

        UserModel result = userService.createUser(userDto);

//        Assert.assertEquals();
    }
}

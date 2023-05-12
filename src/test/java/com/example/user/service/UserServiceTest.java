package com.example.user.service;

import com.example.user.common.BussinessException;
import com.example.user.common.error.UserError;
import com.example.user.persistence.entity.User;
import com.example.user.persistence.repository.UserRepository;
import com.example.user.presentor.dto.CreateUserDto;
import com.example.user.presentor.dto.GetUserDto;
import com.example.user.presentor.dto.model.UserModel;
import com.example.user.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    private UserRepository userRepos;

    @Autowired
    private UserService userService;

    @Before
    public void SetUp(){
        userService = new UserService(userRepos);
    }

    @Test
    public void givenEmail_whenFindUserByEmailAndName_ReturnUser() {
//        String mockEmail = "duc2.hmbk@gmail.com";
//        User mockUser = new User(
//                "hmduc",
//                mockEmail,
//                "09148727491",
//                "123",
//                9999999981L
//        );
//        GetUserDto dto = new GetUserDto();
//        dto.setId(1);
//        Optional<User> user = Mockito.when(userService.getUser(dto)).thenReturn(Us);
    }
}

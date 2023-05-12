package com.example.user.entity;

import com.example.user.common.BussinessException;
import com.example.user.common.error.UserError;
import com.example.user.persistence.entity.User;
import com.example.user.persistence.repository.UserRepository;
import com.example.user.presentor.dto.CreateUserDto;
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

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserTest {
    @MockBean
    private UserRepository userRepos;

    @Autowired
    private UserService userService;

    @Before
    public void SetUp(){
        userService = new UserService(userRepos);
    }

    @Test
    public void givenWrongPhoneNumber_whenCreateUser_thenReturnInvalidPhonwNumber() {
        String wrongPhoneNumber = "91749zc8a9";

        Assert.assertThrows(UserError.InvalidPhoneNumber.class, () -> new User(
                "hmduc",
                "duc2.hmbk@gmail.com",
                wrongPhoneNumber,
                "123",
                9999999981L));
    }

    @Test
    public void givenWrongEmail_whenCreateUser_thenReturnInvalidEmail() {
        String wrongEmail = "bnbdbbagmail.com";

        Assert.assertThrows(UserError.InvalidEmail.class, () -> new User(
                "hmduc",
                wrongEmail,
                "0917938131",
                "123",
                9999999981L));
    }
}

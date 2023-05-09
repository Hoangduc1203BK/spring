package com.example.user.service;

import com.example.user.common.BussinessException;
import com.example.user.persistence.repository.UserRepository;
import com.example.user.persistence.entity.User;
import com.example.user.presentor.dto.CreateUserDto;
import com.example.user.presentor.dto.GetUserDto;
import com.example.user.presentor.model.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepos;

    @Autowired
    public UserService(UserRepository userRepos) {
        this.userRepos = userRepos;
    }

    public UserModel createUser(CreateUserDto data) {
        Optional<User> user = userRepos.findByEmail(data.getEmail());
        if(user.isPresent()) {
            throw new BussinessException("User already exist with email");
        }

        User payload = new User(
                data.getName(),
                data.getEmail(),
                data.getPassword(),
                data.getPhoneNumber(),
                data.getBalance());
        User resource = userRepos.save(payload);
        ModelMapper modelMapper = new ModelMapper();
        UserModel result = modelMapper.map(resource, UserModel.class);

        return result;
    }

    public UserModel getUser(GetUserDto params) {
        User user = userRepos.findById(params.getId().longValue()).orElseThrow(() -> new BussinessException("User not found"));

        ModelMapper modelMapper = new ModelMapper();
        UserModel result = modelMapper.map(user, UserModel.class);

        return result;
    }

    public List<UserModel> listUser() {
        List<User> users = (List<User>) userRepos.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<UserModel> result = users.stream().map(source -> modelMapper.map(source,UserModel.class)).collect(Collectors.toList());

        return result;
    }
}

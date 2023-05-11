package com.example.user.service;

import com.example.user.common.BussinessException;
import com.example.user.common.error.UserError;
import com.example.user.common.validator.Validator;
import com.example.user.persistence.repository.UserRepository;
import com.example.user.persistence.entity.User;
import com.example.user.presentor.dto.CreateUserDto;
import com.example.user.presentor.dto.GetUserDto;
import com.example.user.presentor.dto.ListUserDto;
import com.example.user.presentor.model.UserModel;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepos;
    private Validator validator;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    public UserService(UserRepository userRepos) {
        this.userRepos = userRepos;
        this.validator = new Validator();
    }

    public UserModel createUser(CreateUserDto data) {
        if(!validator.isValidEmail(data.getEmail())) {
            logger.error(new UserError.InvalidEmail().getMessage());
            throw new UserError.InvalidEmail();
        }

        if(!validator.isValidPhoneNumber(data.getPhoneNumber())) {
            logger.error(new UserError.InvalidPhoneNumber(data.getPhoneNumber()).getMessage());
            throw new UserError.InvalidPhoneNumber(data.getPhoneNumber());
        }
        Optional<User> user = userRepos.findByEmailAndPhonenumber(data.getEmail(), null);
        if(user.isPresent()) {
            logger.error(new UserError.EmailExist(data.getEmail()).getMessage());
            throw new UserError.EmailExist(data.getEmail());
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
        Optional<User> user = userRepos.findById(params.getId().longValue());
        if(!user.isPresent()) {
            logger.error(new UserError.UserNotFound().getMessage());
            throw new UserError.UserNotFound();
        }

        ModelMapper modelMapper = new ModelMapper();
        UserModel result = modelMapper.map(user.get(), UserModel.class);

        return result;
    }

    public UserModel getUserInfor(GetUserDto params) {
        if(params.getEmail() != null && !validator.isValidEmail(params.getEmail())) {
            logger.error(new UserError.InvalidEmail().getMessage());
            throw new UserError.InvalidEmail();
        }

        if(params.getPhoneNumber() != null && !validator.isValidPhoneNumber(params.getPhoneNumber())) {
            logger.error(new UserError.InvalidPhoneNumber(params.getPhoneNumber()).getMessage());
            throw new UserError.InvalidPhoneNumber(params.getPhoneNumber());
        }

        Optional<User> user = userRepos.findByEmailAndPhonenumber(
                params.getEmail(), params.getPhoneNumber()
        );

        if(!user.isPresent()) {
            logger.error(new UserError.UserNotFound().getMessage());
            throw new UserError.UserNotFound();
        }
        ModelMapper modelMapper = new ModelMapper();
        UserModel result = modelMapper.map(user.get(), UserModel.class);

        return result;
    }

    public List<UserModel> listUser(ListUserDto listUserDto) {
        Pageable pageable = PageRequest.of(listUserDto.getPage()-1, listUserDto.getLimit());
        Page<User> users = userRepos.findAll(pageable);
        ModelMapper modelMapper = new ModelMapper();
        List<UserModel> result = users.stream().map(source -> modelMapper.map(source,UserModel.class)).collect(Collectors.toList());

        return result;
    }
}

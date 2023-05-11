package com.example.user.persistence.entity;

import com.example.user.common.error.UserError;
import com.example.user.common.validator.Validator;
import com.example.user.service.UserService;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity(name="user")
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    @Column(name="balance", nullable = false, columnDefinition = "BIGINT")
    private Long balance;

    public User() {}

    public User(String name, String email, String password, String phoneNumber, Long balance) {
        Logger logger = LoggerFactory.getLogger(UserService.class);
        Validator validator = new Validator();
        System.out.println("aaaaaaa");

        if(!validator.isValidEmail(email)){
            logger.error(new UserError.InvalidEmail(email).getMessage());
            throw new UserError.InvalidEmail(email);
        }

        if(!validator.isValidPhoneNumber(phoneNumber)) {
            logger.error(new UserError.InvalidPhoneNumber(phoneNumber).getMessage());
            throw new UserError.InvalidPhoneNumber(phoneNumber);
        }

        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    public Integer getId() {return id;}

    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getPassword() {return password;}
    public Long getBalance() {return balance;}


}

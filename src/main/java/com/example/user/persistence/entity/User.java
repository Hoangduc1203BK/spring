package com.example.user.persistence.entity;

import jakarta.persistence.*;

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

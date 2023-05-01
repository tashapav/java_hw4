package com.example.java_hw4;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private Integer age;
    public User(Long id, String login, String name, String surname, Integer age) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

}

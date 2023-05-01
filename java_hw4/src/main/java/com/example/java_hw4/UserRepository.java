package com.example.java_hw4;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public ArrayList<User> users;

    public UserRepository() {
        users = new ArrayList<User>();
        users.add(new User(0L,"masha223456@gmail.com", "Masha", "Ivanova", 19));
        users.add(new User(1L,"dasha223456@gmail.com", "Dasha", "Ivanova", 47));
        users.add(new User(2L,"anna223456@gmail.com", "Anna", "Ivanova", 12));
        users.add(new User(3L,"egor223456@gmail.com", "Egor", "Ivanov", 26));
        users.add(new User(4L,"sasha223456@gmail.com", "Sasha", "Ivanov", 24));
        users.add(new User(5L,"dasha@gmail.com", "Dasha", "Ivanova", 52));
    }
}
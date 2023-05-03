package com.example.java_hw4;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    public static String FromLikeToRegexp(String data) {
        data = data.toLowerCase().replace(".", "\\.").replace("?", ".").replace("%", ".*");
        return data;
    }

}

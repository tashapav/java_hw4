package com.example.java_hw4.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import java.util.ArrayList;

@Value
public class ResponseV3 {
    @NotNull
    private Integer count;
    @NotNull
    @Deprecated(forRemoval = true)
    private ArrayList<String> login;
    @NotNull
    private ArrayList<UserInfo> users;

    @Value
    public static class UserInfo {
        @NotNull
        private String login;
        @NotNull
        private String name;
        @NotNull
        private String surname;
    }
}

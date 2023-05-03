package com.example.java_hw4.response;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import java.util.ArrayList;

@Value
public class ResponseV1 {
    @NotNull
    private ArrayList<String> login;
}
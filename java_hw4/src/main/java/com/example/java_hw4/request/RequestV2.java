package com.example.java_hw4.request;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.Value;

@Value
public class RequestV2 {
    private String like;
    @Nullable
    private String regex;
}

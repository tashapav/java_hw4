package com.example.java_hw4.request;

import jakarta.annotation.Nullable;
import lombok.Value;

@Value
public class RequestV3 {
    private String like;
    @Nullable
    private String regex;
    @Nullable
    private String surname;
    @Nullable
    private Integer minAge;
    @Nullable
    private Integer maxAge;
}

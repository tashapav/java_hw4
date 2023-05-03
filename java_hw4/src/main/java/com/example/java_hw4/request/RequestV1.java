package com.example.java_hw4.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestV1 {
    @Nullable
    private String like;
}

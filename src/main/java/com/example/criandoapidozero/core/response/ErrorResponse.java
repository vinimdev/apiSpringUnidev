package com.example.criandoapidozero.core.response;

import lombok.Data;

@Data
public class ErrorResponse {

    private String error;

    private int status;
}

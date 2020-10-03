package com.example.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorObject {

    private String message;
    private String field;
    private Object parameter;
}
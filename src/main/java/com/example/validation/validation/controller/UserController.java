package com.example.validation.validation.controller;

import com.example.validation.validation.dto.request.UserRegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @PostMapping("/register")
    ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        // ... Service call to persist new user here
        return ResponseEntity.ok("User is valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(
            MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            String defaultMessage = objectError.getDefaultMessage();
            errors.add(defaultMessage);
        }
        return errors;
    }

    // ... Other methods here

}
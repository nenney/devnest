package com.projects.devnest.common.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Component
public class ValidationUtil {

    public Map<String, String> validateBindingResult(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }

    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        // 최소 8자, 영문, 숫자, 특수문자 포함
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }

    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        // 영문, 숫자, 언더스코어만 허용, 3-20자
        return username.matches("^[a-zA-Z0-9_]{3,20}$");
    }
} 
package com.projects.devnest.common.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;
    private final HttpStatus status;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.status = errorCode.getStatus();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.status = errorCode.getStatus();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }
} 
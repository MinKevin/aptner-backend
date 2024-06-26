package com.aptner.v3.global.exception;

import com.aptner.v3.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    private final String subject;
    private final ErrorCode errorCode;

    GlobalException(String message) {
        super(message);
        this.subject = null;
        this.errorCode = null;
    }

    GlobalException(ErrorCode errorCode) {
        super();
        this.subject = null;
        this.errorCode = errorCode;
    }

    public GlobalException(String subject, ErrorCode errorCode) {
        super();
        this.subject = subject;
        this.errorCode = errorCode;
    }

    public GlobalException(String subject, ErrorCode errorCode, String msg) {
        super(msg);
        this.subject = subject;
        this.errorCode = errorCode;
    }
}

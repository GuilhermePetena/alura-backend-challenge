package com.alura.backendchallenge.config.exception.error;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
public class ResponseException {
    private String method;
    private String path;
    private String errorMessage;
    private Object errorDetail;

    public ResponseException(HttpServletRequest httpServletRequest, String errorMessage, Object errorDetail) {
        this.method = httpServletRequest.getMethod();
        this.path = httpServletRequest.getRequestURI();
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }
}

package com.daovantam.travel02.controller;

import com.daovantam.travel02.model.response.DataResponse;
import com.daovantam.travel02.util.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
@Validated
public class BaseController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        String code = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String message = ErrorCode.getMessage(code);

        DataResponse dataResponse = new DataResponse();
        dataResponse.setCode(code);
        dataResponse.setMessage(message);

        return ResponseEntity.ok(dataResponse);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<?> handleNotBlank(ConstraintViolationException e){
        DataResponse dataResponse = new DataResponse();
        dataResponse.setCode(ErrorCode.Code.NOT_BLANK);
        dataResponse.setMessage(ErrorCode.NOT_BLANK.message());
        return ResponseEntity.ok(dataResponse);
    }

}

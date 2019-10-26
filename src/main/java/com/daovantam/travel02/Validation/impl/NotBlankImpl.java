package com.daovantam.travel02.Validation.impl;

import com.daovantam.travel02.Validation.NOTBLANK;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class NotBlankImpl implements ConstraintValidator<NOTBLANK, String> {

    @Override
    public boolean isValid(String userRequest, ConstraintValidatorContext constraintValidatorContext) {
        return !(userRequest == null || userRequest.length() <= 0);
    }

}

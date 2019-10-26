package com.daovantam.travel02.Validation;

import com.daovantam.travel02.Validation.impl.NotBlankImpl;
import com.daovantam.travel02.util.ErrorCode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Constraint(validatedBy = NotBlankImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NOTBLANK {
    String message() default ErrorCode.Code.NOT_BLANK;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

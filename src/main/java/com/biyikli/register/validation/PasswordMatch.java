package com.biyikli.register.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchValidator.class)
public @interface PasswordMatch {

    // define default error message
    String message() default "Passwords don't match";

    // define default groups
    public Class<?>[] groups() default {};

    // define default pay loads
    public Class<? extends Payload>[] payload() default {};
}

package com.biyikli.register.validation;

import com.biyikli.register.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object dto, ConstraintValidatorContext context) {
        UserDto userDto = (UserDto) dto;

        boolean isMatch = userDto.getPassword().equals(userDto.getMatchingPassword());

        if(!isMatch){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("password").addConstraintViolation();
        }

        return isMatch;
    }
}

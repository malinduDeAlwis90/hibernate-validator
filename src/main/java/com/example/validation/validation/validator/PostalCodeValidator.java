package com.example.validation.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostalCodeValidator implements
        ConstraintValidator<PostalCodeConstraint, Integer> {

    @Override
    public void initialize(PostalCodeConstraint contactNumber) {
    }

    @Override
    public boolean isValid(Integer contactField,
                           ConstraintValidatorContext context) {
        return contactField != null && contactField.toString().matches("\\d{5}");
    }
}
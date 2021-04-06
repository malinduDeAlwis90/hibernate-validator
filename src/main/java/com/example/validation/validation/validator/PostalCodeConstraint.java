package com.example.validation.validation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PostalCodeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PostalCodeConstraint {
    String message() default "Postal code should be valid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
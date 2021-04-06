package com.example.validation.validation.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class StartEndDateValidator implements ConstraintValidator<StartEndDate, Object> {

    private String startDate;
    private String endDate;

    public void initialize(StartEndDate constraintAnnotation) {
        this.startDate = constraintAnnotation.startDate();
        this.endDate = constraintAnnotation.endDate();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        LocalDate startDateValue = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(startDate);
        LocalDate endDateValue = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(endDate);

        if (startDateValue != null && endDateValue != null) {
            return startDateValue.isBefore(endDateValue);
        } else {
            return false;
        }
    }
}

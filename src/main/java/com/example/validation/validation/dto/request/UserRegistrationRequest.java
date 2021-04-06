package com.example.validation.validation.dto.request;

import com.example.validation.validation.validator.PostalCodeConstraint;
import com.example.validation.validation.validator.StartEndDate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

@StartEndDate.List({
        @StartEndDate(
                startDate = "startDate",
                endDate = "endDate",
                message = "End date should be after start date." // Put a message if needed to override the default message.
        )
})

public class UserRegistrationRequest {

    @NotBlank(message="Name should not be blank.")
    public String name;
    @Length(min = 5, max = 500, message = "Address should contain 5 to 500 characters.")
    public String address;
    @Email(message = "Email should be valid.")
    public String email;
    @PostalCodeConstraint
    public Integer postalCode;
    public LocalDate startDate;
    public LocalDate endDate;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}

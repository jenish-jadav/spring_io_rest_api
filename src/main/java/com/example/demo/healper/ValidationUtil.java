package com.example.demo.healper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;

import com.example.demo.models.ApiResponse;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ValidationUtil {

    public static ApiResponse getErrorMessage(Errors errors) {
        List<ConstraintViolation<?>> violationsList = new ArrayList<>();
        for (ObjectError e : errors.getAllErrors()) {
            violationsList.add(e.unwrap(ConstraintViolation.class));
            break;
        }

        List<String> erroeMessage=new ArrayList<>();

        // Construct a helpful message for each input violation
        for (ConstraintViolation<?> violation : violationsList) {
            // += violation.getPropertyPath() + " " + violation.getMessage() + "\n";
            erroeMessage.add(violation.getMessage());
        }
        return ApiResponse.SetErrorResponse(erroeMessage.get(0));
    }

    

}

package com.ReportingAPI.webapp.ReportingAPI.util;

import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;

import com.ReportingAPI.webapp.ReportingAPI.model.error.BaseError;

import java.util.List;
import java.util.stream.Collectors;


public class ErrorUtils {

    public static List<BaseError> getValidationErrors(List<FieldError> fieldErrors) {
        return null;
    }
}

package com.ynov;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationService {
    private static ValidationService instance;
    private Validator validator;

    public static ValidationService getInstance()
    {
        if (instance == null)
            instance = new ValidationService();
        return instance;
    }

    public Validator getValidator() {
        return validator;
    }

    public ValidationService()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
}

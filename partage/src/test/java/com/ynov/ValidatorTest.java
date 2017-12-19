package com.ynov;
import org.junit.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class ValidatorTest {
    @Test
    public void testValidationService()
    {
        ValidationService service = ValidationService.getInstance();
        assertNotNull(service);
        assertNotNull(service.getValidator());
    }
}

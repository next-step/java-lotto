package lottogame.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputLineValidatorTest {

    private InputLineValidator validator = new InputLineValidator();

    @Test
    public void isValid_for_null() {
        assertFalse(validator.isValid(null));
    }

    @Test
    public void isValid_for_empty() {
        assertFalse(validator.isValid(""));
    }

    @Test
    public void isValid_for_string() {
        assertTrue(validator.isValid("aa aa"));
    }
}
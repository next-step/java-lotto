package lottogame.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputLineValidatorTest {

    private final InputLineValidator validator = new InputLineValidator();

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
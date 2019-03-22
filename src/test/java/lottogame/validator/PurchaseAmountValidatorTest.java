package lottogame.validator;

import org.junit.Test;

import static lottogame.domain.PurchaseAmount.LOTTO_PRICE;
import static org.junit.Assert.*;

public class PurchaseAmountValidatorTest {
    PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @Test
    public void isValid_for_null() {
        assertFalse(validator.isValid(null));
    }

    @Test
    public void isValid_for_zero() {
        assertFalse(validator.isValid(0L));
    }

    @Test
    public void isValid_for_less_than_LOTTO_PRICE() {
        assertFalse(validator.isValid(LOTTO_PRICE-1));
    }

    @Test
    public void isValid_for_LOTTO_PRICE() {
        assertTrue(validator.isValid(LOTTO_PRICE));
    }

    @Test
    public void isValid_for_maximum_value() {
        assertTrue(validator.isValid(Long.MAX_VALUE-1));
    }

    @Test
    public void isValid_for_Long_MAX_VALUE() {
        assertFalse(validator.isValid(Long.MAX_VALUE));
    }

}
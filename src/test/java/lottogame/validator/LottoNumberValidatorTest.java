package lottogame.validator;

import org.junit.Test;

import static lottogame.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lottogame.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static org.junit.Assert.*;

public class LottoNumberValidatorTest {

    private final LottoNumberValidator validator = new LottoNumberValidator();
    
    @Test
    public void isValid_for_null() {
        assertFalse(validator.isValid(null));
    }

    @Test
    public void isValid_for_less_than_MINIMUM_LOTTO_NUMBER() {
        assertFalse(validator.isValid(MINIMUM_LOTTO_NUMBER-1));
    }

    @Test
    public void isValid_for_MINIMUM_LOTTO_NUMBER() {
        assertTrue(validator.isValid(MINIMUM_LOTTO_NUMBER));
    }

    @Test
    public void isValid_for_MAXIMUM_LOTTO_NUMBER() {
        assertTrue(validator.isValid(MAXIMUM_LOTTO_NUMBER));
    }

    @Test
    public void isValid_for_more_than_MAXIMUM_LOTTO_NUMBER() {
        assertFalse(validator.isValid(MAXIMUM_LOTTO_NUMBER+1));
    }
}
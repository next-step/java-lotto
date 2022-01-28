package stringcalculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


class ValidatorTest {

    @Test
    void 구분된_문자는_숫자여야_한다_성공() {
        final String token = "1";
        assertDoesNotThrow(() -> Validator.validateTypeOfToken(token));
    }

    @Test
    void 구분된_문자는_숫자여야_한다_실패() {
        final String token = "k";
        assertThrows(NumberFormatException.class,
            () -> Validator.validateTypeOfToken(token));
    }

    @Test
    void 구분된_문자는_반드시_양수의_숫자여야_한다_성공() {
        final List<String> tokens = Arrays.asList("1", "2", "3");
        assertDoesNotThrow(() -> Validator.validatePositiveNumber(tokens));
    }

    @Test
    void 구분된_문자는_반드시_양수의_숫자여야_한다_실패() {
        final List<String> tokens = Arrays.asList("1", "-2", "3");
        assertThrows(IllegalArgumentException.class,
            () -> Validator.validatePositiveNumber(tokens));
    }
}

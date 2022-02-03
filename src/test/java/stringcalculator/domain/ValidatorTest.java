package stringcalculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


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

    @ValueSource(strings = {"1", "2", "3"})
    @ParameterizedTest
    void 구분된_문자는_반드시_양수의_숫자여야_한다_성공(String number) {
        assertDoesNotThrow(() -> Validator.validatePositiveNumber(number));
    }

    @ValueSource(strings = {"1", "-2", "3"})
    @ParameterizedTest
    void 구분된_문자는_반드시_양수의_숫자여야_한다_실패(String number) {
        assertThrows(IllegalArgumentException.class,
            () -> Validator.validatePositiveNumber(number));
    }
}

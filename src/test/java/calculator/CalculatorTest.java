package calculator;

import org.junit.jupiter.api.Test;

import static calculator.Calculator.cal;
import static calculator.exception.CustomExceptionCode.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void divide() {
        assertEquals(2, cal("4 / 2"));
        assertEquals(1, cal("4 / 3"));
    }

    @Test
    void multiple() {
        assertEquals(6, cal("2 * 3"));
    }

    @Test
    void plus() {
        assertEquals(5, cal("2 + 3"));
    }

    @Test
    void minus() {
        assertEquals(1, cal("3 - 2"));
    }

    @Test
    void nullInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal(null))
                .withMessage(NULL_OR_BLANK_INPUT.getMessage());
    }

    @Test
    void notFourBasicOperations() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal("2 & 3 + 2 * 4"))
                .withMessage(NOT_FOUR_BASIC_OPERATIONS.getMessage());
    }

    @Test
    void complexCalculations() {
        assertEquals(10, cal("2 + 3 * 4 / 2"));
    }

    @Test
    void incompleteFormula() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal("2 - 3 + 2 * 4 +"))
                .withMessage(INCOMPLETED_FORMULA.getMessage());
    }

    @Test
    void inputOnlyNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal("2 - 3 3 2 * 4 +"))
                .withMessage(NOT_FOUR_BASIC_OPERATIONS.getMessage());
    }

}
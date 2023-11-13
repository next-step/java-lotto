package calculator;

import org.junit.jupiter.api.Test;

import static calculator.exception.CustomExceptionCode.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void divide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.cal("4 / 2"));
        assertEquals(1, calculator.cal("4 / 3"));
    }

    @Test
    void multiple() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.cal("2 * 3"));
    }

    @Test
    void plus() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.cal("2 + 3"));
    }

    @Test
    void minus() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.cal("3 - 2"));
    }

    @Test
    void nullInput() {
        Calculator calculator = new Calculator();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.cal(null))
                .withMessage(NULL_OR_BLANK_INPUT.getMessage());
    }

    @Test
    void notFourBasicOperations() {
        Calculator calculator = new Calculator();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.cal("2 & 3 + 2 * 4"))
                .withMessage(NOT_FOUR_BASIC_OPERATIONS.getMessage());
    }

    @Test
    void complexCalculations() {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.cal("2 + 3 * 4 / 2"));
    }

    @Test
    void incompleteFormula() {
        Calculator calculator = new Calculator();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.cal("2 - 3 + 2 * 4 +"))
                .withMessage(INCOMPLETED_FORMULA.getMessage());
    }

    @Test
    void inputOnlyNumbers() {
        Calculator calculator = new Calculator();
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.cal("2 - 3 3 2 * 4 +"))
                .withMessage(NOT_FOUR_BASIC_OPERATIONS.getMessage());
    }

}
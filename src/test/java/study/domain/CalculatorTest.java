package study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.util.FormulaParser;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("계산 테스트")
    void calculate() {
        // Given
        final String formula = "2 + 3 * 4 / 2";
        final Calculator calculator = new Calculator(new FormulaParser(formula));

        // When
        final int result = calculator.calculate();

        // Then
        assertEquals(10, result);
    }

    @Test
    @DisplayName("계산 예외 테스트")
    void calculateException() {
        // Given
        final String formula = "2 + 3 * 4 / / 2";
        final Calculator calculator = new Calculator(new FormulaParser(formula));

        // When
        final int result = calculator.calculate();

        // Then
        assertNotEquals(11, result);
    }

}
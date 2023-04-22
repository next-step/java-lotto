package study.domain;

import org.junit.jupiter.api.Test;
import study.domain.util.FormulaParser;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        // Given
        final String formula = "2 + 3 * 4 / 2";
        final Calculator calculator = new Calculator(new FormulaParser(formula));

        // When
        final int result = calculator.calculate();

        // Then
        assertEquals(10, result);
    }

}
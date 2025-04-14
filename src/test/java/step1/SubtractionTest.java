package step1;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.domain.Calculator;
import step1.domain.Number;

public class SubtractionTest {
    @Test
    @DisplayName("뺄셈 연산")
    public void subtractionTest() {
        String operator = "-";
        Number left = Number.of(2);
        Number right = Number.of(3);
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(left, right, operator);
        assertEquals(BigDecimal.valueOf(-1), result.getValue());
    }
}

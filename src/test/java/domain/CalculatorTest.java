package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.domain.Calculator;
import step1.domain.Number;

public class CalculatorTest {
    @Test
    @DisplayName("부적합한 연산 테스트")
    public void invalidInputTest() {
        String[] input = "1 + ".split(" ");
        Calculator calculator = new Calculator();
        assertThatThrownBy(
            () -> calculator.calculate(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산 테스트")
    public void inputTest() {
        String[] input = "1 + 2 + 3".split(" ");
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(input);
        assertEquals(result, Number.of(6));
    }
}

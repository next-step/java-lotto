package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step1.domain.Calculator;
import step1.domain.Number;

public class DivisionTest {
    @Test
    @DisplayName("나눗셈 실패연산")
    public void divideTest() {
        String operator = "/";
        Number left = Number.of(1);
        Number right = Number.of(0);
        Calculator calculator = new Calculator();
        assertThatThrownBy(
            () -> calculator.calculate(left, right, operator)
        ).isInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName("나눗셈 연산")
    public void multiplyTest() {
        String operator = "/";
        Number left = Number.of(6);
        Number right = Number.of(3);
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(left, right, operator);
        assertEquals(result.getValue(), BigDecimal.valueOf(2));
    }

    @Test
    @DisplayName("나눗셈 연산 - 소수")
    public void multiplyTest2() {
        String operator = "/";
        Number left = Number.of(6);
        Number right = Number.of(4);
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(left, right, operator);
        assertEquals(result.getValue(), BigDecimal.valueOf(1.5));
    }
}

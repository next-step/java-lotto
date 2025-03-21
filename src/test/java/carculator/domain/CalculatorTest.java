package carculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("숫자 두 개를 가지고 덧셈을 할 수 있다.")
    public void plusTest() {
        int num1 = 3, num2 = 5;

        Integer output = calculator.plus(num1, num2);
        assertThat(output).isEqualTo(num1 + num2);
    }

    @Test
    @DisplayName("숫자 두 개를 가지고 뺄셈을 할 수 있다.")
    public void minusTest() {
        int num1 = 3, num2 = 5;

        Integer output = calculator.minus(num1, num2);
        assertThat(output).isEqualTo(num1 - num2);
    }

    @Test
    @DisplayName("숫자 두 개를 가지고 곱셈을 할 수 있다.")
    public void multiplyTest() {
        int num1 = 3, num2 = 5;

        Integer multiply = calculator.multiply(num1, num2);
        assertThat(multiply).isEqualTo(num1 * num2);
    }

    @Test
    @DisplayName("숫자 두 개를 가지고 나눗셈을 할 수 있다.")
    public void divideTest() {
        int num1 = 6, num2 = 2;

        Integer output = calculator.divide(num1, num2);
        assertThat(output).isEqualTo(3);
    }
}

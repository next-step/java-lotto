package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest implements Addition, Subtraction, Multiplication, Division {
    @Test
    void getOperationResultTest() {
        Calculator calculator = new Calculator();

        assertThat(calculator.testMethod("+", 1, 2)).isEqualTo(3);
        assertThat(calculator.testMethod("-", 1, 2)).isEqualTo(-1);
        assertThat(calculator.testMethod("*", 1, 2)).isEqualTo(2);
        assertThat(calculator.testMethod("/", 1, 2)).isEqualTo(0);
    }

    @Test
    void 덧셈() {
        assertThat(addition(2, 3)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(subtraction(2, 3)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(multiplication(2, 3)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(division(2, 3)).isEqualTo(0);
    }

    @Override
    public int addition(int a, int b) {
        return a + b;
    }

    @Override
    public int division(int a, int b) {
        return a / b;
    }

    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a - b;
    }
}

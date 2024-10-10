package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    void 덧셈() {
        String input = "2 + 3";
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        String input = "5 - 3";
        assertThat(calculator.calculate(input)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        String input = "5 * 3";
        assertThat(calculator.calculate(input)).isEqualTo(15);
    }

    @Test
    void 나눗셈() {
        String input = "15 / 3";
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    void 사칙연산_혼합() {
        String input = "2 + 3 * 4 / 2";
        assertThat(calculator.calculate(input)).isEqualTo(10);
    }

    @Test
    void 연산_기호가_아님() {
        assertThatThrownBy(() -> {
           calculator.calculate("2 ! 3 * 4 / 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

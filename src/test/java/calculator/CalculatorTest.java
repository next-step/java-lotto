package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("+는 덧셈으로 계산")
    void 덧셈() {
        String input = "2 + 3";
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    @DisplayName("-는 뺄셈으로 계산")
    void 뺄셈() {
        String input = "5 - 3";
        assertThat(calculator.calculate(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("*는 곱셈으로 계산")
    void 곱셈() {
        String input = "5 * 3";
        assertThat(calculator.calculate(input)).isEqualTo(15);
    }

    @Test
    @DisplayName("/는 나눗셈으로 계산")
    void 나눗셈() {
        String input = "15 / 3";
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    @DisplayName("일반적인 사칙연산을 따르지 않고 앞에서 순서대로 계산하여 결과를 반환")
    void 사칙연산_혼합() {
        String input = "2 + 3 * 4 / 2";
        assertThat(calculator.calculate(input)).isEqualTo(10);
    }

    @Test
    @DisplayName("사칙연산 기호가 아니면 IllegalArgumentException 반환")
    void 연산_기호가_아님() {
        assertThatThrownBy(() -> {
           calculator.calculate("2 ! 3 * 4 / 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

package calculator;

import calculator.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    @DisplayName("빈값 넣기")
    @Test
    void 빈값테스트() {
        assertThatThrownBy(() -> {
            Calculator.cal(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 연산자 넣기")
    @Test
    void 연산자오류테스트() {
        assertThatThrownBy(() -> {
            Calculator.cal("2 ( 1 + 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 덧셈() {
        assertThat(Calculator.cal("2 + 4 + 6")).isEqualTo(12);
    }
    @Test
    void 뺄셈() {
        assertThat(Calculator.cal("10 - 4 - 6")).isEqualTo(0);
    }
    @Test
    void 곱셈() {
        assertThat(Calculator.cal("2 * 4 * 6")).isEqualTo(48);
    }
    @Test
    void 나눗셈() {
        assertThat(Calculator.cal("12 / 2 / 2")).isEqualTo(3);
    }
}

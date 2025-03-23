package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("+가 주어졌을 때 두 숫자에 대해 덧셈을 진행한다.")
    void sum() {
        assertThat(Calculator.calculate(1, 2, "+")).isEqualTo(3);
    }

    @Test
    @DisplayName("-가 주어졌을 때 두 숫자에 대해 뺄셈을 진행한다.")
    void substract() {
        assertThat(Calculator.calculate(1, 2, "-")).isEqualTo(-1);
    }

    @Test
    @DisplayName("*가 주어졌을 때 두 숫자에 대해 곱셈을 진행한다.")
    void multiply() {
        assertThat(Calculator.calculate(1, 2, "*")).isEqualTo(2);
    }

    @Test
    @DisplayName("/가 주어졌을 때 두 숫자에 대해 나눗셈을 진행한다.")
    void divide() {
        assertThat(Calculator.calculate(4, 2, "/")).isEqualTo(2);
    }

    @Test
    @DisplayName("계산할 때 전달된 기호가 사칙연산 기호가 아니라면 IllegalArgumentException가 발생한다.")
    void bad_operator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(4, 2, "&");
        });
    }
}

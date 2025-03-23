package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    @DisplayName("+가 주어졌을 때 두 숫자에 대해 덧셈을 진행한다.")
    void sum() {
        Assertions.assertThat(Calculator.calculate(1, 2, "+")).isEqualTo(3);
    }

    @Test
    @DisplayName("-가 주어졌을 때 두 숫자에 대해 뺄셈을 진행한다.")
    void substract() {
        Assertions.assertThat(Calculator.calculate(1, 2, "-")).isEqualTo(-1);
    }
}

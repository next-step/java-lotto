package stringcaculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "2,2:2", "//;\n1;2;3"})
    void 계산기_테스트(String expression) {
        Calculator calculator = new Calculator();
        int actualSum = calculator.calculate(expression);
        assertThat(actualSum).isEqualTo(6);
    }

    @Test
    void 빈_값_계산하기() {
        Calculator calculator = new Calculator();
        int actualSum = calculator.calculate("");
        assertThat(actualSum).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-2,3", "1:a:2", "//!\n1!a"})
    void 예외_테스트(String expression) {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculate(expression))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

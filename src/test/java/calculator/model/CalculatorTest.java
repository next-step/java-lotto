package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"1 + 2, 3", "0 + 0, 0"})
    public void 덧셈(String input, int expected) {
        Assertions.assertThat(Calculator.run(new Expression(input)))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"5 - 3, 2", "3 -  5, -2"})
    public void 뺄셈(String input, int expected) {
        Assertions.assertThat(Calculator.run(new Expression(input)))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"2 * 3, 6", "-2 * 3, -6", "2 *  0, 0"})
    public void 곱셈(String input, int expected) {
        Assertions.assertThat(Calculator.run(new Expression(input)))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"4 / 2, 2", "-2 / 1, -2"})
    public void 나눗셈(String input, int expected) {
        Assertions.assertThat(Calculator.run(new Expression(input)))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Expression이 숫자 하나인 경우")
    public void 숫자_하나_연산() {
        Assertions.assertThat(Calculator.run(new Expression("3")))
                .isEqualTo(3);
    }

    @Test
    public void 사칙연산() {
        Assertions.assertThat(Calculator.run(new Expression("1 + 2 / 3 - 1 * 7")))
                .isEqualTo(0);
    }
}

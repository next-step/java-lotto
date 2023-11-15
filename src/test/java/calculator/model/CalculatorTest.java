package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void 덧셈() {
        Assertions.assertThat(Calculator.run(new Expression("1 + 2")))
                .isEqualTo(3);
        Assertions.assertThat(Calculator.run(new Expression("0 + 0")))
                .isEqualTo(0);
    }

    @Test
    public void 뺄셈() {
        Assertions.assertThat(Calculator.run(new Expression("5 - 3")))
                .isEqualTo(2);
        Assertions.assertThat(Calculator.run(new Expression("3 -  5")))
                .isEqualTo(-2);
    }

    @Test
    public void 곱셈() {
        Assertions.assertThat(Calculator.run(new Expression("2 * 3")))
                .isEqualTo(6);
        Assertions.assertThat(Calculator.run(new Expression("-2 * 3")))
                .isEqualTo(-6);
        Assertions.assertThat(Calculator.run(new Expression("2 *  0")))
                .isEqualTo(0);
    }

    @Test
    public void 나눗셈() {
        Assertions.assertThat(Calculator.run(new Expression("4 / 2")))
                .isEqualTo(2);
        Assertions.assertThat(Calculator.run(new Expression("-2 / 1")))
                .isEqualTo(-2);
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

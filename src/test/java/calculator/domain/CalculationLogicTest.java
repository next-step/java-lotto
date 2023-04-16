package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationLogicTest {
    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        // given
        int a = 1;
        int b = 2;
        int expected = 3;

        // when
        int actual = CalculationLogic.add(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtract() {
        // given
        int a = 1;
        int b = 2;
        int expected = -1;

        // when
        int actual = CalculationLogic.subtract(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply() {
        // given
        int a = 1;
        int b = 2;
        int expected = 2;

        // when
        int actual = CalculationLogic.multiply(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        // given
        int a = 5;
        int b = 5;
        int expected = 1;

        // when
        int actual = CalculationLogic.divide(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
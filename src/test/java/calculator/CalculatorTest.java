package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import caculator.Calculator;

class CalculatorTest {

    @Test
    void 덧셈_테스트() {
        // given & when
        final int result = Calculator.calculateTwoNumber(2, "+", 4);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 뺄셈_테스트() {
        // given & when
        final int result = Calculator.calculateTwoNumber(4, "-", 2);

        // then
        assertThat(result).isEqualTo(2);
    }
}

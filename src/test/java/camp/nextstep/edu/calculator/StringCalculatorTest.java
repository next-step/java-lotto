package camp.nextstep.edu.calculator;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

    @NullAndEmptySource
    @ParameterizedTest
    void nullOrEmpty(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("하나의 덧셈 식을 계산한다")
    void onePlus() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("하나의 뺄셈 식을 계산한다")
    void oneMinus() {
        int result = StringCalculator.calculate("1 - 2");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("하나의 곱셈 식을 계산한다")
    void oneMultiply() {
        int result = StringCalculator.calculate("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("하나의 나눗셈 식을 계산한다")
    void oneDivide() {
        int result = StringCalculator.calculate("6 / 3");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("여러 식을 순서대로 계산한다")
    void multiOperatorExpression() {
        int result = StringCalculator.calculate("1 + 2 * 3 / 2");
        assertThat(result).isEqualTo(4);
    }
}

package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void 곱셈_테스트() {
        // given & when
        final int result = Calculator.calculateTwoNumber(2, "*", 2);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 나눗셈_테스트() {
        // given & when
        final int result = Calculator.calculateTwoNumber(4, "/", 2);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 나눗셈_예외_테스트() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculateTwoNumber(4, "/", 0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"$", "#", "&"})
    void 사칙연산_기호_예외_테스트() {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculateTwoNumber(4, "&", 0));
    }
}

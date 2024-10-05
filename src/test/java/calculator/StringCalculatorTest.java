package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @Test
    void 입력값이_빈문자열일경우_예외처리() {
        String value = " ";
        assertThatThrownBy(() -> StringCalculator.run(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_nulll_일경우_예외처리() {
        String value = null;
        assertThatThrownBy(() -> StringCalculator.run(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_덧셈_테스트() {
        String value = "2 + 4";
        int result = StringCalculator.run(value);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 숫자_뺄셈_테스트() {
        String value = "4 - 2";
        int result = StringCalculator.run(value);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 숫자_곱셈_테스트() {
        String value = "4 * 2";
        int result = StringCalculator.run(value);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void 숫자_나눗셈_테스트() {
        String value = "4 / 2";
        int result = StringCalculator.run(value);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 사칙연산_여러개_테스트() {
        String value = "2 + 3 * 4 / 2";
        int result = StringCalculator.run(value);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 숫자_0으로_나눌때_예외처리() {
        String value = "4 / 0";
        assertThatThrownBy(() -> StringCalculator.run(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산자_검증_테스트() {
        String value = "4 & 0";
        assertThatThrownBy(() -> StringCalculator.run(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

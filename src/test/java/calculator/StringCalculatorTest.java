package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class StringCalculatorTest {

    @Test
    @DisplayName("공백을 제거하는지 확인한다")
    void 입력문자열_공백제거() {

        StringCalculator calculator = new StringCalculator();

        Assertions.assertThat(calculator.splitString("2 + 3 * 4 / 2"))
                .containsExactly("2", "+", "3", "*", "4", "/", "2");

    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("공백 혹은 null 입력시 예외를 발생시킨다")
    void 공백문자열_null_입력테스트(String input) {

        StringCalculator calculator = new StringCalculator();

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        calculator.calculate(input))
                .withMessage("null 혹은 공백 문자열은 연산 불가능합니다산 식 (null 혹은 빈문자열)");

    }

}

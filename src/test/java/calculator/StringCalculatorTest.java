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

        StringExpression expression = new StringExpression("2 + 3 * 4 / 2");

        Assertions.assertThat(expression.getSplitedExpression())
                .containsExactly("2", "+", "3", "*", "4", "/", "2");

    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("공백 혹은 null 입력시 예외를 발생시킨다")
    void 공백문자열_null_입력테스트(String input) {

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        new StringExpression(input))
                .withMessage("null 혹은 공백 문자열은 연산 불가능합니다");

    }

}

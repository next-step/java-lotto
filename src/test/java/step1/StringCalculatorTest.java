package step1;

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
        StringCalculator cal = new StringCalculator("2 + 3 * 4 / 2");

        Assertions.assertThat(cal.getString()).isEqualTo("2+3*4/2");

    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("공백 혹은 null 입력시 예외를 발생시킨다")
    void 공백문자열_null_입력테스트(String input) {

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        new StringCalculator(input))
                .withMessage("올바르지 않은 계산 식 (null 혹은 빈문자열)");

    }

}

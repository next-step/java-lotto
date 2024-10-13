package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputItemTypeTest {
    @ParameterizedTest
    @CsvSource(value = {"+:OPERATOR", "1:NUMBER", " :SPACE"}, delimiter = ':', ignoreLeadingAndTrailingWhitespace = false)
    void 입력항목_타입_구하기_검증(String item, InputItemType expected) {
        // when
        InputItemType inputItemType = InputItemType.from(item);

        // then
        Assertions.assertThat(inputItemType).isEqualTo(expected);
    }

    @Test
    void 연산자_숫자_공백_이외의_입력에_대해서는_예외_발생() {
        // given
        String item = "@";

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputItemType.from(item))
                .withMessage("숫자, 사칙연산자(+, -, *, /), 공백 이외의 문자는 허용되지 않습니다");
    }
}

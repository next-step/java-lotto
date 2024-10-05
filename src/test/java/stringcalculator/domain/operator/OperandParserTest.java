package stringcalculator.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.exception.StringCalculatorIllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandParserTest {

    @DisplayName("문자열 숫자를 정수로 변환할 수 있다.")
    @Test
    void parse() {
        String number = "321";

        int result = OperandParser.parse(number);

        assertThat(result).isEqualTo(321);
    }

    @DisplayName("빈 문자열 변환 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void parseWithEmptyString(String input) {
        assertThatThrownBy(() -> OperandParser.parse(input))
                .isInstanceOf(StringCalculatorIllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자열 변환 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "*"})
    void parseWithNoNumericString(String input) {
        assertThatThrownBy(() -> OperandParser.parse(input))
                .isInstanceOf(StringCalculatorIllegalArgumentException.class);
    }
}
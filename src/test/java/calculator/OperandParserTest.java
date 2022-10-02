package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.InvalidOperandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperandParserTest {

    @Test
    @DisplayName("주어진 문자열을 피연산자 숫자로 변환.")
    void parse_string_to_operand_number() {
        String operandStr = "15";

        assertThat(OperandParser.parse(operandStr)).isEqualTo(15);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열을 피연산자 숫자로 변환 시도 시 예외 발생.")
    void fail_to_parse_by_invalid_string() {
        String operandStr = "숫자";

        assertThatThrownBy(() -> OperandParser.parse(operandStr))
                .isInstanceOf(InvalidOperandException.class);
    }
}

package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTypeTest {
    @DisplayName("연산자에 따른 계산을 수행한다.")
    @ParameterizedTest
    @CsvSource(value = {"PLUS,3,5,8", "MINUS,3,5,-2", "TIMES,3,5,15", "DIVISION,5,5,1"})
    void calculate(OperatorType operator, Integer firstOperand, Integer secondOperand, Integer result) {
        assertThat(operator.execute(new OperandNumber(firstOperand), new OperandNumber(secondOperand)))
                .isEqualTo(new OperandNumber(result));
    }

    @DisplayName("사칙 연산자 문자열 값 입력 시 OperatorType을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,TIMES", "/,DIVISION"})
    void return_OperatorType_from_String_input(String strInput, OperatorType result) {
        assertThat(OperatorType.from(strInput)).isEqualTo(result);
    }

    @Test
    @DisplayName("사칙 연산자 외 값 입력 시 IllegalArgumentException을 발생시킨다.")
    void throw_IllegalArgumentException_when_input_is_not_arithmetic_operators() {
        assertThatIllegalArgumentException().isThrownBy(() -> OperatorType.from("&"))
                .withMessage("해당 값 '&'은 사칙 연산자에 해당하지 않습니다.");
    }
}

package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    @DisplayName("더하기 기능 테스트")
    void plusTest(int operand1, int operand2) {
        Operator operator = Operator.getOperator("+");
        assertThat(operator.calculate(operand1, operand2))
                .isEqualTo(operand1 + operand2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    @DisplayName("빼기 기능 테스트")
    void minusTest(int operand1, int operand2) {
        Operator minus = Operator.getOperator("-");
        assertThat(minus.calculate(operand1, operand2))
                .isEqualTo(operand1 - operand2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    @DisplayName("곱셈 기능 테스트")
    void multipleTest(int operand1, int operand2) {
        Operator operator = Operator.getOperator("*");
        assertThat(operator.calculate(operand1, operand2))
                .isEqualTo(operand1 * operand2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    @DisplayName("나누기 기능 테스트")
    void divideTest(int operand1, int operand2) {
        Operator operator = Operator.getOperator("/");
        assertThat(operator.calculate(operand1, operand2))
                .isEqualTo(operand1 / operand2);
    }

    @ParameterizedTest
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLE", "/,DIVIDE"})
    @DisplayName("연산자 테스트")
    void getOperatorTest(String input, String result) {
        assertThat(Operator.getOperator(input)).isEqualTo(Operator.valueOf(result));
    }

    @Test
    @DisplayName("연산자 에러 테스트")
    void getOperatorErrorTest() {
        assertThatThrownBy(() -> Operator.getOperator("^"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 연산자가 아닙니다.");
    }

    @Test
    @DisplayName("0 나누기 에러 테스트")
    void zeroDivideErrorTest() {
        Operator operator = Operator.getOperator("/");
        assertThatThrownBy(() -> operator.calculate(2, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}

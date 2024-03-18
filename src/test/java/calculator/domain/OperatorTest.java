package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {
    @Nested
    @DisplayName("findOperator() 테스트")
    class FindOperatorTest {
        @Test
        @DisplayName("지원하지 않는 연사자라면 IllegalArgumentException이 발생한다.")
        void testFailCase() {
            assertThatThrownBy(() -> Operator.findOperator("&"))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
        @DisplayName("지원하는 연산자라면 연산자에 해당되는 Enum을 반환한다.")
        void testSuccessCase(String operator, Operator operatorEnum) {
            assertThat(Operator.findOperator(operator)).isEqualTo(operatorEnum);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:2", "1:2:3", "2:-1:1"}, delimiter = ':')
    @DisplayName("PLUS.calculate(): 더하기 연산을 수행합니다.")
    public void testPlusCalculate(double number1, double number2, double result) {
        assertThat(Operator.PLUS.calculate(number1, number2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "1:2:-1", "2:-1:3"}, delimiter = ':')
    @DisplayName("MINUS.calculate(): 빼기 연산을 수행합니다.")
    public void testMinusCalculate(double number1, double number2, double result) {
        assertThat(Operator.MINUS.calculate(number1, number2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "1:2:2", "2:-1:-2", "0.1:9:0.9"}, delimiter = ':')
    @DisplayName("MULTIPLY.calculate(): 곱하기 연산을 수행합니다.")
    public void testMultiplyCalculate(double number1, double number2, double result) {
        assertThat(Operator.MULTIPLY.calculate(number1, number2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "1:2:0", "2:-1:-2", "0.1:3:0"}, delimiter = ':')
    @DisplayName("DIVIDE.calculate(): 곱하기 연산을 수행합니다.")
    public void testDivideCalculate(double number1, double number2, double result) {
        assertThat(Operator.DIVIDE.calculate(number1, number2)).isEqualTo(result);
    }
}

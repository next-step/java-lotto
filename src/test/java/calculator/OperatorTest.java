package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    // 지원하는 연산자인지를 확인해야 한다.
    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "*:true", "/:true", "%:false", "abs:false"}, delimiter = ':')
    @DisplayName("isValidOperator(): 사칙연산자가 아닌 경우 false를 반환합니다.")
    public void testIsValidOperator(String operator, boolean expected) {
        assertThat(Operator.isValidOperator(operator)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:2", "1:2:3", "2:-1:1"}, delimiter = ':')
    @DisplayName("PLUS.calculate(): 더하기 연산을 수행합니다.")
    public void testPlusCalculate(double num1, double num2, double result) {
        assertThat(Operator.PLUS.calculate(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "1:2:-1", "2:-1:3"}, delimiter = ':')
    @DisplayName("MINUS.calculate(): 빼기 연산을 수행합니다.")
    public void testMinusCalculate(double num1, double num2, double result) {
        assertThat(Operator.MINUS.calculate(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "1:2:2", "2:-1:-2", "0.1:9:0.9"}, delimiter = ':')
    @DisplayName("MULTIPLY.calculate(): 곱하기 연산을 수행합니다.")
    public void testMultiplyCalculate(double num1, double num2, double result) {
        assertThat(Operator.MULTIPLY.calculate(num1, num2)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "1:2:0", "2:-1:-2", "0.1:3:0"}, delimiter = ':')
    @DisplayName("DIVIDE.calculate(): 곱하기 연산을 수행합니다.")
    public void testDivideCalculate(double num1, double num2, double result) {
        assertThat(Operator.DIVIDE.calculate(num1, num2)).isEqualTo(result);
    }
}
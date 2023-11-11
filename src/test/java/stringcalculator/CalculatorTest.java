package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @DisplayName("인자로 받은 연산 기호가 (+, -, *, /)중 일치하는 것이 있는 지 확인한다.")
    @ParameterizedTest
    @CsvSource({"+,true", "-,true", "*,true", "/,true", ":,false", "=,false"})
    void validateSymbol(String symbol, boolean expectedResult) {
        // when & then
        assertThat(Calculator.isOperationSymbol(symbol)).isEqualTo(expectedResult);
    }

    @DisplayName("Calculator 생성시 초기 값을 인자로 주고 연산 기호와 다음 숫자를 인자로 받아 사칙 연산을 한다.")
    @ParameterizedTest
    @CsvSource({"+,5,8", "-,5,-2", "*,5,15", "/,2,1.5"})
    void calculate(String symbol, double nextNum, double expectedResult) {
        // given
        double initValue = 3;
        Calculator calculator = new Calculator(initValue);

        // when
        double realResult = calculator.calculateBy(symbol, nextNum);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }
}
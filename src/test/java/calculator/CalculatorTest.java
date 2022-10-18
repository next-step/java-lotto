package calculator;

import calculator.exception.CalculatorErrorCode;
import calculator.exception.OperationErrorCode;
import exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("+ 연산 기호로 주어진 수를 더한다")
    @Test
    void plus() {
        String str = "1 + 1 + 3";
        assertThat(Calculator.splitAndCalculate(str)).isEqualTo(5);
    }

    @DisplayName("- 연산 기호로 주어진 수를 뺀다")
    @Test
    void minus() {
        String str = "2 - 1";
        assertThat(Calculator.splitAndCalculate(str)).isEqualTo(1);
    }

    @DisplayName("* 연산 기호로 주어진 수를 곱한다")
    @Test
    void multiply() {
        String str = "2 * 3";
        assertThat(Calculator.splitAndCalculate(str)).isEqualTo(6);
    }

    @DisplayName("/ 연산 기호로 주어진 수를 나눈다")
    @Test
    void division() {
        String str = "6 / 2";
        assertThat(Calculator.splitAndCalculate(str)).isEqualTo(3);
    }

    @DisplayName("input 값에 null 혹은 공백이 들어오면 테스트가 실패한다")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "")
    void inputNull(String str) {
        assertThatThrownBy(() -> Calculator.splitAndCalculate(str))
                .isInstanceOf(CustomException.class)
                .hasMessage(CalculatorErrorCode.INPUT_VALUE_NULL_POINT_ERROR.getMessage());
    }

    @DisplayName("정해지지 않은 연산기호 입력시 테스트가 실패한다")
    @Test
    void badSymbolRequest() {
        assertThatThrownBy(() -> Calculator.splitAndCalculate("4 { 6"))
                .isInstanceOf(CustomException.class)
                .hasMessage(OperationErrorCode.NOT_OPERATION_SYMBOL.getMessage());
    }

    @DisplayName("모든 연산기호로 계산이 되는지 테스트한다")
    @Test
    void allSymbol() {
        String str = "1 + 3 * 5 / 4 - 1";
        assertThat(Calculator.splitAndCalculate(str)).isEqualTo(4);
    }
}

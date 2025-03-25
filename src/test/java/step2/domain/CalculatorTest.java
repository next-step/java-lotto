package step2.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {
        "10, 20, +, 30",
        "10, 20, -, -10",
        "10, 20, *, 200",
        "10, 20, /, 0"
    })
    @DisplayName("사칙연산 테스트")
    void testCalculate(int num1, int num2, String operator, int expectedResult) {
        ExpressionElement element = new ExpressionElement(List.of(num1, num2), List.of(operator));
        int result = Calculator.calculate(element);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "10, 20, %"
    })
    @DisplayName("지원하지 않는 연산자 테스트")
    void testCalculate_UnsupportedOperator(int num1, int num2, String operator) {
        ExpressionElement element = new ExpressionElement(List.of(num1, num2), List.of(operator));
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(element))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "10, 0, /"
    })
    @DisplayName("0으로 나누기 테스트")
    void testCalculate_DivisionByZero(int num1, int num2, String operator) {
        ExpressionElement element = new ExpressionElement(List.of(num1, num2), List.of(operator));
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(element))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

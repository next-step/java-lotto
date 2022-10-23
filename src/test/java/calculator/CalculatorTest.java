package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("덧셈연산 테스트")
    void plus() {
        assertThat(calculator.calculate("1 + 1 + 3")).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈연산 테스트")
    void minus() {
        assertThat(calculator.calculate("5 - 3 - 1")).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈연산 테스트")
    void multiply() {
        assertThat(calculator.calculate("3 * 2 * 3")).isEqualTo(18);
    }

    @Test
    @DisplayName("나눗셈연산 테스트")
    void divide() {
        assertThat(calculator.calculate("7 / 2 / 3")).isEqualTo(1);
    }

    @Test
    @DisplayName("통합연산 테스트")
    void allOperation() {
        assertThat(calculator.calculate("7 + 2 / 3 * 2 - 1")).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ",";","1 +3","+1+4","가 + 다","1 ( 4","3"})
    void test(String input) {
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

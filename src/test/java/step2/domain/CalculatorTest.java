package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.domain.Calculator.calculate;

class CalculatorTest {
    @ParameterizedTest
    @CsvSource({
        "10, 5, +, 15",
        "10, 5, -, 5",
        "10, 5, *, 50",
        "10, 5, /, 2",
        "-10, 5, +, -5",
        "-10, 5, -, -15",
        "-10, 5, *, -50",
        "-10, 5, /, -2"
    })
    @DisplayName("사칙연산 테스트")
    void testCalculator(int number1, int number2, String operator, int expected) {
        int result = calculate(number1, number2, operator);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("0으로 나누기 테스트")
    void testDivisionByZero() {
        assertThatThrownBy(() -> calculate(10, 0, "/"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지원하지 않는 연산자 테스트")
    void testUnsupportedOperator() {
        assertThatThrownBy(() -> calculate(10, 5, "%"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

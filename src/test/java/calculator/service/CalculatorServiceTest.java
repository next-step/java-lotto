package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorServiceTest {

    CalculatorService calculatorService;

    @BeforeEach
    void setup() {
        calculatorService = new CalculatorService();
    }

    @DisplayName("Null이나 빈값이면 에러를 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void 빈값이면_에러를_반환(String expression) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> calculatorService.calculate(expression));
    }

    @DisplayName("사칙연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {
        "1 + 1 = 2",
        "2 - 1 = 1",
        "4 / 2 = 2",
        "3 * 3 = 9"
    }, delimiter = '=')
    void 사칙연산_테스트(String expression, int expected) {
        int result = calculatorService.calculate(expression);

        assertThat(result).isEqualTo(expected);
    }

}
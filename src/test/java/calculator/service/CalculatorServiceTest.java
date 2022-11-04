package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import calculator.domain.Number;
import calculator.domain.Operator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
            () -> calculatorService.getOperations(expression));
    }

    @DisplayName("정수 값들만 Number 객체에 담는다")
    @Test
    void 정수값들을_Number_객체에_담는다() {
        List<String> expressions = List.of("0", "+", "12");

        List<Number> result = calculatorService.getNumbers(expressions);

        assertThat(result).isEqualTo( List.of( new Number("0"), new Number("12") ));
    }

    @DisplayName("연산자만 리스트에 저장한다")
    @Test
    void 연산자값들만_리스트에_저장() {
        List<String> expressions = List.of("0", "+", "12");

        List<Operator> result = calculatorService.getOperators(expressions);

        assertThat(result).isEqualTo(List.of(Operator.PLUS));
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
        List<String> splitResult = calculatorService.getOperations(expression);
        List<Number> numbers = calculatorService.getNumbers(splitResult);
        List<Operator> operators = calculatorService.getOperators(splitResult);

        int result = calculatorService.calculate(numbers, operators);

        assertThat(result).isEqualTo(expected);
    }

}
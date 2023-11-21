package calculator;

import static calculator.Calculator.INPUT_OPERATOR_EXCEPTION;
import static calculator.Calculator.INPUT_TEXT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.operator.DivideOperator;
import calculator.operator.MinusOperator;
import calculator.operator.MultiplyOperator;
import calculator.operator.Operator;
import calculator.operator.PlusOperator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private List<Operator> operators;

    @BeforeEach
    void setUp() {
        operators = List.of(
                new PlusOperator(),
                new MinusOperator(),
                new MultiplyOperator(),
                new DivideOperator()
        );
    }

    @Test
    @DisplayName("덧셈을 할 수 있다.")
    void plus() {
        // given
        Calculator calculator = new Calculator(operators);
        String given = "1 + 3";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("뺼셈을 할 수 있다.")
    void minus() {
        // given
        Calculator calculator = new Calculator(operators);
        String given = "2 - 4";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("곱셈을 할 수 있다.")
    void multiply() {
        // given
        Calculator calculator = new Calculator(operators);
        String given = "3 * 5";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("나눗셈을 할 수 있다.")
    void divide() {
        // given
        Calculator calculator = new Calculator(operators);
        String given = "15 / 3";

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외를 던진다.")
    @NullAndEmptySource
    void input_text_exception(String given) {
        // given
        Calculator calculator = new Calculator(operators);

        // when // then
        assertThatThrownBy(() -> calculator.calculate(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_TEXT_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 경우 예외를 던진다.")
    @ValueSource(strings = {"3 ^ 4", "8 # 7"})
    void input_operator_exception(String given) {
        // given
        Calculator calculator = new Calculator(operators);

        // when // then
        assertThatThrownBy(() -> calculator.calculate(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_OPERATOR_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("여러 사칙 연산을 한 개의 수식에서 사용할 수 있다.")
    @CsvSource(value = {"3 + 4 * 6, 42", "4 - 8 * 2 / 8 + 3, 2"})
    void use_multiple_arithmetic_operations(String given, long expected) {
        // given
        Calculator calculator = new Calculator(operators);

        // when
        long result = calculator.calculate(given);

        // then
        assertThat(result).isEqualTo(expected);
    }
}

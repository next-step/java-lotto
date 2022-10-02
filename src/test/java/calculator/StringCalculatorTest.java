package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("여러_숫자_덧셈_테스트")
    @CsvSource(value = {
            "10 + 10 + 10 + 10 + 10=50",
            "20 + 20 + 20 + 20 + 20=100",
            "10 + 20 + 30 + 40 + 50=150"
    }, delimiter = '=')
    void many_numbers_add_test(String formula, int expected) {
        assertThat(StringCalculator.operate(formula)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("여러_숫자_뺄셈_테스트")
    @CsvSource(value = {
            "100 - 3 - 3 - 4 - 4=86",
            "50 - 2 - 3=45"
    }, delimiter = '=')
    void many_numbers_substract_test(String formula, int expected) {
        assertThat(StringCalculator.operate(formula)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("여러_숫자_곱셈_테스트")
    @CsvSource(value = {
            "100 * 3 * 3 * 4 * 4 * 0=0",
            "50 * 2 * 4=400"
    }, delimiter = '=')
    void many_numbers_multiply_test(String formula, int expected) {
        assertThat(StringCalculator.operate(formula)).isEqualTo(expected);
    }

    @Test
    @DisplayName("여러_숫자_나눗셈_테스트")
    void many_numbers_divide_test() {
        String input = "100 / 2 / 5 / 3";
        String input0 = "100 / 2 / 5 / 0";

        assertThat(StringCalculator.operate(input)).isEqualTo(3);
        assertThatThrownBy(() -> StringCalculator.operate(input0))
                .isInstanceOf(IllegalArgumentException.class)
        ;
    }

    @ParameterizedTest
    @DisplayName("여러_숫자_사칙연산_테스트")
    @CsvSource(value = {
            "2 + 3 * 4 / 2=10"
    }, delimiter = '=')
    void many_numbers_complex_operation_test(String formula, int expected) {
        assertThat(StringCalculator.operate(formula)).isEqualTo(expected);
    }

    @Test
    @DisplayName("잘못된_사칙연산_검증_테스트")
    void bad_operation_validation_test() {
        String input = "1 / 4 + 10 ( 4";
        assertThatThrownBy(() -> StringCalculator.operate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 올바르지 않습니다.");
        ;
    }

    @Test
    @DisplayName("빈값_검증_테스트")
    void empty_value_validation_test() {
        assertThatThrownBy(() -> StringCalculator.operate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null이나 빈 값은 입력할 수 없습니다.");
        ;

        assertThatThrownBy(() -> StringCalculator.operate("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null이나 빈 값은 입력할 수 없습니다.");
        ;

        assertThatThrownBy(() -> StringCalculator.operate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null이나 빈 값은 입력할 수 없습니다.");
        ;
    }

}

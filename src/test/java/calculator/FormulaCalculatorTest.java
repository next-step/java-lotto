package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import calculator.exception.EmptyFormulaException;
import calculator.exception.InvalidFormulaException;
import calculator.exception.InvalidOperandException;
import calculator.exception.InvalidOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class FormulaCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "15 + 17 * 20 - 1:639"}, delimiter = ':')
    @DisplayName("연산이 가능한 수식 문자열로 계산")
    void calculate_valid_formula(String formula, int expected) {
        int result = FormulaCalculator.calculate(formula);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("빈 문자열로 연산 시도 시 예외 발생")
    void fail_to_calculate_by_empty_formula(String formula) {
        assertThatExceptionOfType(EmptyFormulaException.class)
                .isThrownBy(() -> FormulaCalculator.calculate(formula));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 ? 4 / 2", "15 + 17 * 20 ! 1"})
    @DisplayName("사칙연산자가 아닌 연산자를 포함한 문자열로 연산 시도 시 예외 발생")
    void fail_to_calculate_by_invalid_operator(String formula) {
        assertThatExceptionOfType(InvalidOperatorException.class)
                .isThrownBy(() -> FormulaCalculator.calculate(formula));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + A * 4 / 2", "15 + 17 * 20 - ?"})
    @DisplayName("숫자가 아닌 피연산자를 포함한 문자열로 연산 시도 시 예외 발생")
    void fail_to_calculate_by_invalid_operand(String formula) {
        assertThatExceptionOfType(InvalidOperandException.class)
                .isThrownBy(() -> FormulaCalculator.calculate(formula));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / ", "15 + 17 *"})
    @DisplayName("연산하기엔 피연산자가 부족하게 만들어진 수식으로 연산 시도 시 예외 발생")
    void fail_to_calculate_by_invalid_formula(String formula) {
        assertThatExceptionOfType(InvalidFormulaException.class)
                .isThrownBy(() -> FormulaCalculator.calculate(formula));
    }

    @Test
    @DisplayName("수식에 0으로 나누는 연산이 존재하면 하면 예외 발생.")
    void fail_to_divide_by_zero() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> FormulaCalculator.calculate("5 / 0"));
    }

}

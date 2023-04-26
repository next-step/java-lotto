package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    void 사칙연산_기호로_Calculator_클래스를_찾는다(String operator, Calculator expected) {
        final var actual = Calculator.findOperator(operator);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 사칙연산_기호가_아닐경우_예외를_던진다() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.findOperator("&")
        );
    }

    @Test
    void 두_숫자_plus() {
        final var calculator = Calculator.PLUS;

        final var actual = calculator.calculate(2, 3);

        assertThat(actual).isEqualTo(5);
    }

    @Test
    void 두_숫자_minus() {
        final var calculator = Calculator.MINUS;

        final var actual = calculator.calculate(10, 5);

        assertThat(actual).isEqualTo(5);
    }

    @Test
    void 두_숫자_multiply() {
        final var calculator = Calculator.MULTIPLY;

        final var actual = calculator.calculate(5, 4);

        assertThat(actual).isEqualTo(20);
    }

    @Test
    void 두_숫자_divide() {
        final var calculator = Calculator.DIVIDE;

        final var actual = calculator.calculate(20, 2);

        assertThat(actual).isEqualTo(10);
    }

}
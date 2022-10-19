package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @ParameterizedTest
    @NullSource
    @EmptySource
    void create(String equation) {
        assertThatThrownBy(() -> calculator.calculate(equation))
                .isInstanceOf(CaculateException.class)
                .hasMessage(ErrorCode.CALCULATE_NULL.getErrorMessage());
    }

    @Test
    void one_number() {
        assertThat(calculator.calculate("1")).isEqualTo(new Number(1));
    }

    @Test
    void two_number_with_operator() {
        assertThat(calculator.calculate("1 + 2")).isEqualTo(new Number(3));
    }

    @Test
    void wrong_equation() {
        assertThatThrownBy(() -> calculator.calculate("2 + 2 - 1 1"))
                .isInstanceOf(CaculateException.class)
                .hasMessage(ErrorCode.WRONG_EQUATION_FORMAT.getErrorMessage());
    }
}

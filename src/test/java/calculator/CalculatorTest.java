package calculator;

import calculator.exception.EmptyValueException;
import calculator.exception.InvalidValueException;
import calculator.exception.WrongOperatorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void 사칙연산기호_아닌경우_예외() {
        assertThatThrownBy(() -> Calculator.calculate("1 + 4 * 4 / 2 #"))
                .isInstanceOf(InvalidValueException.class);
    }

    @Test
    void 입력값_빈_공백_예외() {
        assertThatThrownBy(() -> Calculator.calculate(""))
                .isInstanceOf(EmptyValueException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "100 + 100 * 2 / 2,200",
            "10 * 5 / 2 + 10 - 2,33",
            "10 + 10 / 2 + 1 * 4,44"
    })
    void 사칙연산_조합_계산(String value, double expected) {
        double calculate = Calculator.calculate(value);
        assertThat(calculate).isEqualTo(expected);
    }
}

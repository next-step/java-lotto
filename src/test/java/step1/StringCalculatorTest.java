package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step1.StringCalculator.calculate;

public class StringCalculatorTest {

    @Test
    void 빈공백_구분자로_구분() {
        int result = calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_빈공백_입력값(String input) {
        assertThatThrownBy(() -> {
            calculate(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 사칙연산_기호_아님() {
        assertThatThrownBy(() -> {
            calculate("1 & 2");
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "2 + 3 * 4 / 2 - 5=5"}, delimiter = '=')
    void 사칙연산(String input, int expected) {
        assertThat(calculate(input)).isEqualTo(expected);
    }
}

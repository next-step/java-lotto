package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    @Test
    void 덧셈() {
        assertThat(StringCalculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(StringCalculator.subtract(2, 1)).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        assertThat(StringCalculator.multiply(5, 4)).isEqualTo(20);
    }

    @Test
    void 나눗셈() {
        assertThat(StringCalculator.divide(20, 2)).isEqualTo(10);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값_null_이거나_빈공백문자열(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.splitAndCalculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "^", "&"})
    void 사칙연산_기호가_아닌_경우(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.splitAndCalculate(input);
        });
    }
}

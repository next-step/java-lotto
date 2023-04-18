package StringCalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static StringCalculator.StringCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3,5", "2 - 3,-1", "2 * 3,6", "2 / 3,0", "2 / 3 + 1,1"})
    void 사칙연산(String input, int expected) {
        assertThat(calculate(input)).isEqualTo(expected);
    }

    @Test
    void 입력값이null이거나_빈공백문자일경우_IllegalArgumentException() {
        assertAll(
                () -> {
                    assertThatIllegalArgumentException().isThrownBy(() -> calculate(""));
                },
                () -> {
                    assertThatIllegalArgumentException().isThrownBy(() -> calculate(null));
                }
        );
    }

    @Test
    void 사칙연산기호가아닌경우_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculate("2 & 3"));
    }

}

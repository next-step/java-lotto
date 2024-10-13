package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    @Test
    void calculate_계산을_수행한다() {
        assertThat(StringCalculator.calculate("2 + 3")).isEqualTo(5);
    }

    @Test
    void calculate_인자순서대로_계산을_수행한다() {
        assertThat(StringCalculator.calculate("2 + 3 * 4")).isEqualTo(20);
    }

    @Test
    void calculate_계산식이_null인_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void calculate_계산식이_빈_공백인_경우_예외를_발생시킨다(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(expression));
    }
}

package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void testBlankInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

    @Test
    void testNullInput() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(null));
    }

    @Test
    void testEvenTokenCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("2 +"));
    }

    @Test
    void testInvalidNumberPosition() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("+ 3"));
    }

    @Test
    void testInvalidOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("2 % 3"));
    }

    @Test
    void testValidCalculation() {
        int result = calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}
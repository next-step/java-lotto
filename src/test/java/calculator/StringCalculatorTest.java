package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    @Test
    void testCalculate() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate("3 + 2")).isEqualTo(5);
        assertThat(stringCalculator.calculate("3 - 2")).isEqualTo(1);
        assertThat(stringCalculator.calculate("3 * 2")).isEqualTo(6);
        assertThat(stringCalculator.calculate("3 / 2")).isEqualTo(1);
    }

    @Test
    void testSplitInput() {
        StringCalculator stringCalculator = new StringCalculator();
        String[] tokens = stringCalculator.splitInput("3 + 2");
        assertThat(tokens).hasSize(3);
        assertThat(tokens).containsExactly("3", "+", "2");
    }

    @Test
    void testParseNumberException() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(
                IllegalArgumentException.class,
                () -> stringCalculator.parseNumber("a"));
    }
}
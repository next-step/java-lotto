package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void testAdd() {
        String input = "2 + 3";
        int expected = 5;
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testSubtract() {
        String input = "2 - 3";
        int expected = -1;
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testMultiply() {
        String input = "2 * 3";
        int expected = 6;
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testDivide() {
        String input = "20 / 2";
        int expected = 10;
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void intputNullOrEmpty(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculate(input));
    }
}

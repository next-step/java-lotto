package stringCalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource({
            "2 + 3, 5",
            "3 - 2, 1",
            "3 / 2, 1",
            "2 * 3, 6",
            "2 + 3 * 4 / 2, 10",
            "2 - 3 * 5, -5"
    })
    void testCalculate(String input, int result) {
        assertEquals(result, stringCalculator.calculate(input));
    }

    @Test
    void testInvalidCalculate() {
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.calculate("2 + + 3"));
    }
}

package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @Test
    void testCalculate() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(5, stringCalculator.calculate("3 + 2"));
        assertEquals(1, stringCalculator.calculate("3 - 2"));
        assertEquals(6, stringCalculator.calculate("3 * 2"));
        assertEquals(1, stringCalculator.calculate("3 / 2"));
    }

}
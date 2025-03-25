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

    @Test
    void testSplitInput() {
        StringCalculator stringCalculator = new StringCalculator();
        String[] tokens = stringCalculator.splitInput("3 + 2");
        assertEquals(3, tokens.length);
        assertEquals("3", tokens[0]);
        assertEquals("+", tokens[1]);
        assertEquals("2", tokens[2]);
    }
}
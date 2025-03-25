package calculator.operator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinusTest {

    @Test
    void testIsOperator() {
        Minus minus = new Minus();
        assertTrue(minus.isOperator("-"));
        assertFalse(minus.isOperator("+"));
    }

    @Test
    void testCalculate() {
        Minus minus = new Minus();
        assertEquals(1, minus.calculate(3, 2));
    }
}
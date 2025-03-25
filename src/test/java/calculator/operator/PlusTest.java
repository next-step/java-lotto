package calculator.operator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusTest {

    @Test
    void testIsOperator() {
        Plus plus = new Plus();
        assertTrue(plus.isOperator("+"));
        assertFalse(plus.isOperator("-"));
    }

    @Test
    void testCalculate() {
        Plus plus = new Plus();
        assertEquals(3, plus.calculate(1, 2));
    }
}
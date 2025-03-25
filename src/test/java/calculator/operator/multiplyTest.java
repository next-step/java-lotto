package calculator.operator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {

    @Test
    void testIsOperator() {
        Multiply multiply = new Multiply();
        assertTrue(multiply.isOperator("*"));
        assertFalse(multiply.isOperator("+"));
    }

    @Test
    void testCalculate() {
        Multiply multiply = new Multiply();
        assertEquals(6, multiply.calculate(3, 2));
    }
}
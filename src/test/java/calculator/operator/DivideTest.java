package calculator.operator;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {

    @org.junit.jupiter.api.Test
    void testIsOperator() {
        Divide divide = new Divide();
        assertTrue(divide.isOperator("/"));
        assertFalse(divide.isOperator("+"));
    }

    @org.junit.jupiter.api.Test
    void testCalculate() {
        Divide divide = new Divide();
        assertEquals(3, divide.calculate(6, 2));
    }
}
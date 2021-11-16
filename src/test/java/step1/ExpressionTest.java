package step1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    void expression() {
        Expression expression = new Expression("1,2:3");
    }

    @Test
    void hasNextNumber() {
        Expression hasNext = new Expression("1,2:3");
        assertTrue(hasNext.hasNextNumber());

        Expression empty = new Expression("");
        assertFalse(empty.hasNextNumber());
    }

    @Test
    void nextNumber() {
        Expression expression = new Expression("1,2:3");
        assertEquals(1, expression.nextNumber());
        assertEquals(2, expression.nextNumber());
        assertEquals(3, expression.nextNumber());
    }
}

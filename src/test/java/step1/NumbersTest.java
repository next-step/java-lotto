package step1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void numbers() {
        Numbers numbers = new Numbers(new String[]{"1","2"});
        Numbers empty = new Numbers();
    }

    @Test
    void isEmpty() {
        Numbers numbers = new Numbers(new String[]{"1","2"});
        assertFalse(numbers.isEmpty());

        Numbers empty = new Numbers();
        assertTrue(empty.isEmpty());
    }

    @Test
    void nextNumber() {
        Numbers numbers = new Numbers(new String[]{"1"});
        assertEquals(new Number(1), numbers.nextNumber());
    }
}

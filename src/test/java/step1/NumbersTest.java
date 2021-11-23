package step1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void numbers() {
        Numbers numbers = new Numbers(new String[]{"1", "2"});
        Numbers empty = new Numbers();

        assertEquals(new Number(3), numbers.sum());
        assertEquals(new Number(0), empty.sum());
    }

    @Test
    void sum() {
        Numbers sumIs6 = new Numbers(new String[]{"1", "2", "3"});
        assertEquals(new Number(6), sumIs6.sum());

        Numbers sumIs10 = new Numbers(new String[]{"1", "2", "3", "4"});
        assertEquals(new Number(10), sumIs10.sum());
    }
}

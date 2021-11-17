package step1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void numbers() {
        Numbers numbers = new Numbers(new String[]{"1", "2"});
        Numbers empty = new Numbers();
    }

    @Test
    void sum() {
        Numbers sumIs6 = new Numbers(new String[]{"1", "2", "3"});
        Number ans6 = sumIs6.sum();
        assertEquals(new Number(6), ans6);

        Numbers sumIs10 = new Numbers(new String[]{"1", "2", "3", "4"});
        Number ans10 = sumIs10.sum();
        assertEquals(new Number(10), ans10);
    }
}

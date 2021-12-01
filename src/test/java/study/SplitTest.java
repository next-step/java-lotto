package study;

import org.junit.jupiter.api.Test;

public class SplitTest {
    @Test
    void split() {
        for (String string : "1, 2, 3, 4, 5".split(", ")) {
            System.out.println(string);
        }
    }
}

package stringCalculator;

import static org.junit.Assert.*;
import org.junit.Test;


public class SplitTest {

    @Test
    public void split_숫자와_쉼표하나() {
        assertArrayEquals(new String[]{"5"}, "5,".split(","));
    }
}

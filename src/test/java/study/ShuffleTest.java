package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {

    @Test
    void shuffle() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Collections.shuffle(integers);

        System.out.println(integers);
    }
}

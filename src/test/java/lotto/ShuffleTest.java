package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {
    @Test
    void shuffle() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Collections.shuffle(numbers);
        System.out.println(numbers);

        Collections.shuffle(numbers);
        System.out.println(numbers);

        Collections.shuffle(numbers);
        System.out.println(numbers);
    }
}

package lotto.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTest {

    @Test
    void shuffleTest() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        System.out.println("===== shffle 전 =====");
        System.out.println(numbers);

        System.out.println("===== shffle 후 =====");
        Collections.shuffle(numbers);
        System.out.println(numbers);
    }

}

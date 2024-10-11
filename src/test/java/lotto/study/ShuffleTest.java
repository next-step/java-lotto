package lotto.study;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class ShuffleTest {
    @Test
    void shuffle() {
        List<Integer> list = Arrays.asList(
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15,
                16, 17, 18, 19, 20,
                21, 22, 23, 24, 25,
                26, 27, 28, 29, 30,
                31, 32, 33, 34, 35,
                36, 37, 38, 39, 40,
                41, 42, 43, 44, 45
        );
        System.out.println("before list = " + list);
        Collections.shuffle(list);
        System.out.println("after list = " + list);

        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < 6; index++) {
            result.add(list.get(index));
        };

        System.out.println("before result = " + result);
        result.sort(Integer::compareTo);
        System.out.println("after result = " + result);
    }
}

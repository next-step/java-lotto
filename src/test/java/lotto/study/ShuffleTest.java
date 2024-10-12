package lotto.study;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleTest {
    @Test
    void shuffle() {
        List<Integer> list = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        System.out.println("before list = " + list);
        Collections.shuffle(list);
        System.out.println("after list = " + list);

        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < 6; index++) {
            result.add(list.get(index));
        }
        ;

        System.out.println("before result = " + result);
        result.sort(Integer::compareTo);
        System.out.println("after result = " + result);
    }
}

package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniqueRandomNumberProvider {
    public static List<Integer> provideInRange(int min, int max, int count) {
        List<Integer> ranged = IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList());
        Collections.shuffle(ranged);
        return ranged.subList(0, count);
    }
}

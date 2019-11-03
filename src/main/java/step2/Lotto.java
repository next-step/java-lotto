package step2;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private static List<Integer> balls = new ArrayList<>();

    public static void init(int min, int max) {
        balls = IntStream.rangeClosed(min, max).boxed().collect(toList());
    }

    public static Set<Integer> getUniques(int limit) {
        Set<Integer> lotto = new HashSet<>();
        Collections.shuffle(balls);
        for (int i = 1; i <= limit; i++) {
            lotto.add(i);
        }
        return lotto;
    }
}

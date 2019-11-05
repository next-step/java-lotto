package step2;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AutoGame implements LottoStrategy {
    private static List<Integer> balls = new ArrayList<>();

    public AutoGame(int min, int max) {
        balls = IntStream.rangeClosed(min, max).boxed().collect(toList());
    }

    public Set<Integer> getNumbers(int limit) {
        Collections.shuffle(balls);
        return new HashSet<>(balls.subList(0, limit));
    }
}

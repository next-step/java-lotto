package step2;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class UserNumbers implements LottoNumberStrategy {
    private static List<Integer> balls = new ArrayList<>();

    public UserNumbers(int min, int max) {
        balls = IntStream.rangeClosed(min, max).boxed().collect(toList());
    }

    public Set<Integer> getUniques(int limit) {
        Set<Integer> lotto = new HashSet<>();
        Collections.shuffle(balls);
        for (int i = 0; i < limit; i++) {
            lotto.add(balls.get(i));
        }
        return lotto;
    }
}

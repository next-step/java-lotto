package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Prize {

    private static final Map<Integer, Integer> prize = new HashMap<>();

    static {
        prize.put(3, 5000);
        prize.put(4, 50000);
        prize.put(5, 1500000);
        prize.put(6, 2000000000);
    }

    public static int win(int count) {
        return Optional.ofNullable(prize.get(count)).orElse(0);
    }
}

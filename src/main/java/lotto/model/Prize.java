package lotto.model;

import java.util.*;

public class Prize {

    static final Map<Integer, List<Integer>> PRIZE = new HashMap<>();

    static {
        initPrize();
    }

    private static void initPrize() {
        PRIZE.put(3, Arrays.asList(5000, 0));
        PRIZE.put(4, Arrays.asList(50000, 0));
        PRIZE.put(5, Arrays.asList(1500000, 0));
        PRIZE.put(6, Arrays.asList(2000000000, 0));
    }

    public static void win(int count) {
        Optional.ofNullable(PRIZE.get(count)).ifPresent(status -> {
            int origin = status.get(1);
            status.set(1, origin + 1);
        });
    }
}

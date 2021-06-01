package lotto.model.config;

import java.util.HashMap;
import java.util.Map;

public final class LottoConfig {
    public static final Map<Integer, Integer> winningRewards = new HashMap<Integer, Integer>(){{
        put(0, 0);
        put(1, 0);
        put(2, 0);
        put(3, 5000);
        put(4, 50000);
        put(5, 1500000);
        put(6, 2000000000);
    }};
}

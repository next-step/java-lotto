package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoPrize {
    private static final Map<String, Integer> prizeMap;

    static {
        prizeMap = new HashMap<>();
        prizeMap.put("3", 5000);
        prizeMap.put("4", 50000);
        prizeMap.put("5", 1500000);
        prizeMap.put("6", 2000000000);
    }

    public static int getPrize(String count) {
        return prizeMap.get(count) == null ? 0 : prizeMap.get(count);
    }
}

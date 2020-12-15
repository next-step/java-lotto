package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RevenueTable {
    private static final Map<Integer, Integer> revenueMap = new HashMap<>();
    static {
        revenueMap.put(3, 5000);
        revenueMap.put(4, 500000);
        revenueMap.put(5, 1500000);
        revenueMap.put(6, 2000000000);
    }

    public static int getRevenue(int sameCount) {
        if(! revenueMap.containsKey(sameCount))
            return 0;

        return revenueMap.get(sameCount);
    }
}

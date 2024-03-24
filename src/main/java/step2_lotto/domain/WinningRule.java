package step2_lotto.domain;

import java.util.LinkedHashMap;

import static step2_lotto.constant.Constant.*;


public class WinningRule {
    private static final long HIT_COUNT_3_REVENUE = 5000L;
    private static final long HIT_COUNT_4_REVENUE = 50000L;
    private static final long HIT_COUNT_5_REVENUE = 1500000L;
    private static final long HIT_COUNT_6_REVENUE = 2000000000L;
    private static final LinkedHashMap<Long, Long> hitCountRevenue = new LinkedHashMap<>();

    static {
        hitCountRevenue.put(HIT_COUNT_3, HIT_COUNT_3_REVENUE);
        hitCountRevenue.put(HIT_COUNT_4, HIT_COUNT_4_REVENUE);
        hitCountRevenue.put(HIT_COUNT_5, HIT_COUNT_5_REVENUE);
        hitCountRevenue.put(HIT_COUNT_6, HIT_COUNT_6_REVENUE);
    }

    public static Long findRevenue(Long count){
        return hitCountRevenue.get(count);
    }
}

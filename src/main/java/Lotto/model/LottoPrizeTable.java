package Lotto.model;

import java.util.Map;

public class LottoPrizeTable {
    static final int MATCHED_3 = 3;
    static final int MATCHED_4 = 4;
    static final int MATCHED_5 = 5;
    static final int MATCHED_6 = 6;

    private static final Map<Integer, Integer> PRIZE_MAP = Map.of(
            MATCHED_3, 5_000,
            MATCHED_4, 50_000,
            MATCHED_5, 1_500_000,
            MATCHED_6, 2_000_000_000
    );

    public static int prize(int matchedNum){
        return PRIZE_MAP.getOrDefault(matchedNum, 0);
    }

}

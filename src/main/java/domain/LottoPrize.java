package domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchNumber;
    private final int prizeMoney;
    private static Map map = new HashMap<>();

    LottoPrize(int matchNumber, int prizeMoney) {
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    static {
        for(LottoPrize lottoPrize : LottoPrize.values()) {
            map.put(lottoPrize.matchNumber, lottoPrize.prizeMoney);
        }
    }

    public static int valueOf(int matchNumber) {
        return (int) map.get(matchNumber);
    }

}

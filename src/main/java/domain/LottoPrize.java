package domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

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

package kr.insup.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {
    First(6, 2000),
    Second(5, 150),
    Third(4, 50),
    Fourth(3, 5),
    None(0, 0);

    private final int match;
    private final int winnings;
    private static Map<Integer, LottoPrize> placeMap = new HashMap<>();

    static {
        for (LottoPrize lottoPrize : values()) {
            placeMap.put(lottoPrize.match, lottoPrize);
        }
    }

    LottoPrize(int match, int winnings) {
        this.match = match;
        this.winnings = winnings;
    }

    public static LottoPrize matchLottoPrize(int match) {
        if (placeMap.containsKey(match)) {
            return placeMap.get(match);
        }

        return None;
    }

    public int winnings() {
        return winnings;
    }

    public int match() {
        return match;
    }
}

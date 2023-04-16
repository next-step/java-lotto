package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIFTH(5, 3, 5_000),
    FOURTH(4, 4, 50_000),
    THIRD(3, 5, 1_500_000),
    SECOND(2, 5, 30_000_000),
    FIRST(1,6, 2_000_000_000);

    private final int prize;
    private final int matchNumber;
    private final int prizeMoney;
    private static Map map = new HashMap<>();

    LottoPrize(int prize, int matchNumber, int prizeMoney) {
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    static {
        for(LottoPrize lottoPrize : LottoPrize.values()) {
            map.put(lottoPrize.prize,
                    Arrays.asList(lottoPrize.matchNumber, lottoPrize.prizeMoney));
        }
    }

    public static List<Integer> valueOf(int prize) {
        return (List<Integer>) map.get(prize);
    }

    public static LottoPrize matchPrize(int matchNumber) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.getMatchNumber() == matchNumber)
                .collect(Collectors.toList())
                .get(0);
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }
}

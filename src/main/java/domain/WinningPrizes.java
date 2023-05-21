package domain;

import java.util.HashMap;
import java.util.Map;

public enum WinningPrizes {
    MISS(0, 0) {

    },
    FIFTH_PRIZE(5, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(3, 1_500_000),
    SECOND_PRIZE(2, 3_000_000),
    FIRST_PRIZE(1, 2_000_000_000);

    public static final int OFFSET = 3;

    private static final Map<Integer, WinningPrizes> WINNING_PRIZES_MAP = new HashMap<>();

    static {
        for (WinningPrizes value : values()) {
            WINNING_PRIZES_MAP.put(value.rank, value);
        }
    }

    private int rank;
    private final int prizeMoney;

    WinningPrizes(int rank, int prizeMoney) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public int calculatePrizeMoney(int count) {
        return prizeMoney * count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getRank() {
        return rank;
    }

    public static WinningPrizes valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < OFFSET) {
            return WinningPrizes.MISS;
        }

        if (WinningPrizes.SECOND_PRIZE.rank == countOfMatch) {
            return decideSecondOrThirdPrizes(matchBonus);
        }

        return WINNING_PRIZES_MAP.get(countOfMatch);
    }

    public static WinningPrizes valueOf(int rank) {
        return WINNING_PRIZES_MAP.get(rank);
    }

    private static WinningPrizes decideSecondOrThirdPrizes(boolean matchBonus) {
        if (matchBonus) {
            return WinningPrizes.SECOND_PRIZE;
        }
        return WinningPrizes.THIRD_PRIZE;
    }
}

package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rank {

    LAST(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private static final int DEFAULT_COUNT = 0;

    private final int winMoney;
    private final int winCount;

    Rank(int winMoney, int winCount) {
        this.winMoney = winMoney;
        this.winCount = winCount;
    }

    public int winMoney() {
        return this.winMoney;
    }

    public int winCount() {
        return this.winCount;
    }

    public static Map<Rank, Integer> createRankMap() {
        Map<Rank, Integer> rankMap = new HashMap<>();
        for (Rank rank : values()) {
            rankMap.put(rank, DEFAULT_COUNT);
        }
        return rankMap;
    }

    public static Rank valueOf(int winCount, boolean matchBonus) {
        if (winCount == SECOND.winCount && matchBonus) {
            return SECOND;
        }
        if (winCount == THIRD.winCount && !matchBonus) {
            return THIRD;
        }

        return calculateLottoRank(winCount);
    }

    private static Rank calculateLottoRank(int winCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.winCount == winCount)
            .findFirst()
            .orElse(Rank.LAST);
    }

}

package lotto.entity;

import java.math.BigDecimal;


public enum Rank {
    FIRST(6, BigDecimal.valueOf(2_000_000_000)),
    SECOND(5, BigDecimal.valueOf(30_000_000)),
    THIRD(5, BigDecimal.valueOf(1_500_000)),
    FOURTH(4, BigDecimal.valueOf(55_000)),
    FIFTH(3, BigDecimal.valueOf(5_000)),
    MISS(0, BigDecimal.valueOf(0));

    private static final int MAX_MISS_COUNT = 2;
    private static final int BONUS_MATCH_COUNT = 5;
    private final int collectCount;
    private final BigDecimal prizeMoney;

    Rank(int collectCount, BigDecimal prizeMoney) {
        this.collectCount = collectCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank result = Rank.MISS;
        if (countOfMatch <= MAX_MISS_COUNT) {
            return Rank.MISS;
        }

        for (Rank rank : Rank.values()) {
            result = winning(result, rank, countOfMatch, matchBonus);
        }

        return result;
    }

    private static Rank winning(Rank result, Rank rank, int collectCount, boolean matchBonus) {
        if (result != Rank.MISS) {
            return result;
        }
        if (collectCount == BONUS_MATCH_COUNT && matchBonus == true) {
            return Rank.SECOND;
        }

        if (collectCount == BONUS_MATCH_COUNT && matchBonus != true) {
            return Rank.THIRD;
        }

        if (rank.collectCount == collectCount) {
            return rank;
        }
        return result;
    }


    public int getCollectCount() {
        return collectCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }
}

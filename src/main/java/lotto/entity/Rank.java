package lotto.entity;

import java.math.BigDecimal;
import java.util.Arrays;


public enum Rank {
    FIRST(6, BigDecimal.valueOf(2_000_000_000), false),
    SECOND(5, BigDecimal.valueOf(30_000_000), true),
    THIRD(5, BigDecimal.valueOf(1_500_000), false),
    FOURTH(4, BigDecimal.valueOf(55_000), false),
    FIFTH(3, BigDecimal.valueOf(5_000), false),
    MISS(0, BigDecimal.valueOf(0), false);

    private static final int MAX_MISS_COUNT = 2;
    private static final int BONUS_MATCH_COUNT = 5;
    private final int collectCount;
    private final BigDecimal prizeMoney;
    private final boolean matchBonus;

    Rank(int collectCount, BigDecimal prizeMoney, boolean matchBonus) {
        this.collectCount = collectCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean bonus) {
        if (countOfMatch == Rank.BONUS_MATCH_COUNT) {
            return Arrays.stream(Rank.values()).filter(rank -> rank.collectCount == countOfMatch && rank.matchBonus == bonus).findFirst().orElse(Rank.MISS);
        }

        if (countOfMatch > MAX_MISS_COUNT) {
            return Arrays.stream(Rank.values()).filter(rank -> rank.collectCount == countOfMatch).findFirst().orElse(Rank.MISS);
        }

        return Rank.MISS;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }
}

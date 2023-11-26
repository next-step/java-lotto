package step2.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int reward;

    public static final LottoRank[] VALUES = values();

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank lottoRank(int matchCount, boolean matchBonus) {
        if (matchCount == LottoRank.THIRD.matchCount && !matchBonus) {return THIRD;}
        return Arrays.stream(LottoRank.VALUES).filter(rank -> rank.matchCount()==matchCount).findFirst().orElse(NONE);
    }

    public int reward() {
        return reward;
    }

    public int matchCount() {
        return matchCount;
    }

    public LottoRank valueOf() {
        return this;
    }
}

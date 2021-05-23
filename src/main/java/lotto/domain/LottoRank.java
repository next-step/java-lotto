package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final int reward;
    private final boolean hasBonusNumber;

    LottoRank(int matchCount, boolean hasBonusNumber, int reward) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.reward = reward;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
    public int matchCount() {
        return matchCount;
    }

    public int reward() {
        return reward;
    }

    public static LottoRank of(int matchCount, boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(lottoRank -> (lottoRank.matchCount() == matchCount && lottoRank.hasBonusNumber() == bonusNumber))
                .findFirst()
                .orElse(MISS);
    }
}

package Lotto;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoRank {
    FIRST_RANK(6, false, new BigDecimal("2000000000"), "(2,000,000,000원)"),
    SECOND_RANK(5, true, new BigDecimal("30000000"), "보너스 볼 일치(30,000,000원)"),
    THIRD_RANK(5, false, new BigDecimal("1500000"), "(1,500,000원)"),
    FOURTH_RANK(4, false, new BigDecimal("50000"), "(50,000원)"),
    FIFTH_RANK(3, false, new BigDecimal("5000"), "(5,000원)");

    private final int hitCount;
    private final BigDecimal rewardAmount;
    private final String description;
    private final boolean isBonusHit;

    LottoRank(int hitCount, boolean isBonusHit, BigDecimal rewardAmount, String description) {
        this.hitCount = hitCount;
        this.isBonusHit = isBonusHit;
        this.rewardAmount = rewardAmount;
        this.description = description;
    }

    public static LottoRank findRank(int hit, boolean isBonusHit) {
        return Arrays.stream(values())
                .filter(rank -> rank.hitCount == hit && rank.isBonusHit == isBonusHit)
                .findFirst()
                .orElse(null);
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public String getDescription() {
        return description;
    }
}

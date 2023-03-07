package lotto.domain.enums;

import java.util.Arrays;

public enum LottoRank {
    THREE_HIT(3, "(5000원)", false),
    FOUR_HIT(4, "(50000원)", false),
    FIVE_HIT(5, "(1500000원)", false),
    FIVE_HIT_WITH_BONUS(5, "보너스 볼 일치(30000000원)", true),
    SIX_HIT(6, "(2000000000원)", false);

    private final int hit;
    private final String rewarding;
    private final boolean isHitBonus;

    LottoRank(int hit, String rewarding, boolean isHitBonus) {
        this.hit = hit;
        this.rewarding = rewarding;
        this.isHitBonus = isHitBonus;
    }

    public static LottoRank findRank(int hit, boolean isHitBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.hit == hit && rank.isHitBonus == isHitBonus)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return this.hit + "개 일치 " + this.rewarding;
    }
}

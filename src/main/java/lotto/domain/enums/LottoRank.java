package lotto.domain.enums;

import java.util.Arrays;

public enum LottoRank {
    THREE_HIT(3, 5000,"(5000원)", false),
    FOUR_HIT(4, 50000,"(50000원)", false),
    FIVE_HIT(5, 1500000,"(1500000원)", false),
    FIVE_HIT_WITH_BONUS(5, 30000000,"보너스 볼 일치(30000000원)", true),
    SIX_HIT(6, 2000000000,"(2000000000원)", true);

    private final int hit;
    private final int rewarding;

    private final String description;

    private final boolean isHitBonus;

    LottoRank(int hit, int rewarding, String description, boolean isHitBonus) {
        this.hit = hit;
        this.rewarding = rewarding;
        this.description = description;
        this.isHitBonus = isHitBonus;
    }

    public static LottoRank findRank(int hit, boolean isHitBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.hit == hit && rank.isHitBonus == isHitBonus)
                .findFirst()
                .orElse(null);
    }

    public int getRewarding() {
        return rewarding;
    }

    public int getHit() {
        return hit;
    }

    @Override
    public String toString() {
        return this.hit + "개 일치 " + this.description;
    }
}

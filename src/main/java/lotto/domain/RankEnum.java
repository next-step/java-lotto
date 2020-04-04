package lotto.domain;

import java.util.Arrays;

public enum RankEnum {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NO_RANK(0, false, 0);

    private int matched;
    private boolean requiredBonus;
    private int reward;

    RankEnum(int matched, boolean requiredBonus, int reward) {
        this.matched = matched;
        this.requiredBonus = requiredBonus;
        this.reward = reward;
    }

    public int getMatched() {
        return this.matched;
    }

    public boolean getRequiredBonus() {
        return this.requiredBonus;
    }

    public int getReward() {
        return this.reward;
    }

    public boolean isWinning() {
        return this.matched >= 3;
    }

    public static RankEnum getRank(int matched, boolean hasBonus) {
        return Arrays.stream(RankEnum.values())
                .filter(r -> r.matched == matched && r.requiredBonus == hasBonus)
                .findFirst()
                .orElse(NO_RANK);
    }
}

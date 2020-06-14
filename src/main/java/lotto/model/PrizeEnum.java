package lotto.model;

import java.util.Arrays;

public enum PrizeEnum {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000),
    FAIL(0, false, 0);

    private int match;
    private boolean bonusMatched;

    private int prize;

    PrizeEnum(int match, boolean bonusMatched, int prize) {
        this.match = match;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
    }

    public double getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }

    public static PrizeEnum getMatchPrizeEnum(int match, boolean bonus) {
        return Arrays.stream(PrizeEnum.values())
                .filter(
                        prizeEnum -> prizeEnum.getMatch() == match && prizeEnum.isBonusMatched() == bonus
                ).findAny().orElse(PrizeEnum.FAIL);
    }
}

package lotto.domain;

public enum PrizeRule {

    THREE(3, 0),
    FOUR(4, 0),
    FIVE(5, 0),
    FIVE_WITH_BONUS(5, 1),
    SIX(6, 0),
    ;

    private final int normalNumberCount;
    private final int bonusNumberCount;

    PrizeRule(int normalNumberCount, int bonusNumberCount) {

        this.normalNumberCount = normalNumberCount;
        this.bonusNumberCount = bonusNumberCount;
    }

    public boolean hasBonusNumber() {

        return bonusNumberCount > 0;
    }

    public int getNormalNumberCount() {

        return normalNumberCount;
    }
}

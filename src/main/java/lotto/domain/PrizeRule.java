package lotto.domain;

public enum PrizeRule {

    THREE(3, false),
    FOUR(4, false),
    FIVE(5, false),
    FIVE_WITH_BONUS(5, true),
    SIX(6, false),
    ;

    private final int normalNumberCount;
    private final boolean hasBonusNumber;

    PrizeRule(int normalNumberCount, boolean hasBonusNumber) {

        this.normalNumberCount = normalNumberCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public boolean hasBonusNumber() {

        return hasBonusNumber;
    }

    public int getNormalNumberCount() {

        return normalNumberCount;
    }
}

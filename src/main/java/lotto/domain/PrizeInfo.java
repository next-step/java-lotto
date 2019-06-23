package lotto.domain;

public enum PrizeInfo {

    THREE(PrizeRule.THREE, 5000),
    FOUR(PrizeRule.FOUR, 50000),
    FIVE(PrizeRule.FIVE, 1500000),
    FIVE_WITH_BONUS(PrizeRule.FIVE_WITH_BONUS, 1500000),
    SIX(PrizeRule.SIX, 2000000000),
    ;

    private final PrizeRule prizeRule;
    private final int prizeMoney;

    PrizeInfo(PrizeRule prizeRule, int prizeMoney) {

        this.prizeRule = prizeRule;
        this.prizeMoney = prizeMoney;
    }

    public PrizeRule getPrizeRule() {

        return prizeRule;
    }

    public int getPrizeMoney() {

        return prizeMoney;
    }
}

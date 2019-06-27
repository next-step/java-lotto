package lotto.domain;

public enum PrizeInfo {

    THREE(PrizeRule.THREE, 5_000),
    FOUR(PrizeRule.FOUR, 50_000),
    FIVE(PrizeRule.FIVE, 1_500_000),
    FIVE_WITH_BONUS(PrizeRule.FIVE_WITH_BONUS, 30_000_000),
    SIX(PrizeRule.SIX, 2_000_000_000),
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

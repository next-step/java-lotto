package lotto.domain;

import lotto.domain.money.Money;

public class YieldCalculator {

    private YieldCalculator() {
    }

    public static double calculateYield(MatchResult matchResult, Money money) {
        return (double) matchResult.getProfit() / (double) money.getValue();
    }
}

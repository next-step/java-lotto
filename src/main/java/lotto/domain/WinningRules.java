package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class WinningRules {

    private final List<WinningRule> rules;

    public WinningRules(List<WinningRule> rules) {
        this.rules = rules;
    }


    public List<WinningRule> getAllRules() {
        return this.rules;
    }

    public static WinningRules getDefaultWinningRules() {
        return new WinningRules(List.of(
                WinningRule.THREE,
                WinningRule.FOUR,
                WinningRule.FIVE,
                WinningRule.SIX
        ));
    }

    public BigDecimal getTotalRateOfReturn(int input, Statistics statistics) {
        int totalReward = 0;
        for (WinningRule winningRule : this.rules) {
            totalReward += statistics.get(winningRule.getMatch()) * winningRule.getReward();
        }
        return BigDecimal.valueOf(totalReward).divide(BigDecimal.valueOf(input), 2, RoundingMode.FLOOR);
    }
}

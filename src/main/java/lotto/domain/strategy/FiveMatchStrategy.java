package lotto.domain.strategy;

import lotto.domain.Lotto;

public class FiveMatchStrategy implements WinningStrategy {

    private static final int FIVE_MATCH = 5;
    private static final String STRATEGY_NAME = "fiveMatch";
    private static final int WINNING_MONEY = 1_500_000;

    @Override
    public boolean matches(Lotto lotto, Lotto winningNumbers) {
        return lotto.calculateMatchCount(winningNumbers) == FIVE_MATCH;
    }

    @Override
    public String getResultKey() {
        return STRATEGY_NAME;
    }

    @Override
    public int getWinningMoney() {
        return WINNING_MONEY;
    }
}

package lotto.domain.strategy;

import lotto.domain.Lotto;

public class ThreeMatchStrategy implements WinningStrategy {

    private static final int THREE_MATCH = 3;
    private static final String STRATEGY_NAME = "threeMatch";
    private static final int WINNING_MONEY = 5_000;

    @Override
    public boolean matches(Lotto lotto, Lotto winningNumbers) {
        return lotto.calculateMatchCount(winningNumbers) == THREE_MATCH;
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

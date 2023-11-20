package lotto.domain.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class FourMatchStrategy implements WinningStrategy{

    private static final int FOUR_MATCH = 4;
    private static final String STRATEGY_NAME = "fourMatch";
    private static final int WINNING_MONEY = 50_000;

    @Override
    public boolean matches(Lotto lotto, Lotto winningNumbers, LottoNumber bonusNumber) {
        return lotto.calculateMatchCount(winningNumbers) == FOUR_MATCH;
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

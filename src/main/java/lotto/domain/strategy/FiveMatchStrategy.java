package lotto.domain.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class FiveMatchStrategy implements WinningStrategy {

    private static final int FIVE_MATCH = 5;
    private static final String STRATEGY_NAME = "fiveMatch";
    private static final int WINNING_MONEY = 1_500_000;

    @Override
    public boolean matches(Lotto lotto, Lotto winningNumbers, LottoNumber bonusNumber) {
        return lotto.calculateMatchCount(winningNumbers) == FIVE_MATCH && !lotto.matchBonusNumber(bonusNumber);
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

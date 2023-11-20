package lotto.domain.strategy;

import lotto.domain.Lotto;

public interface WinningStrategy {
    boolean matches(Lotto lotto, Lotto winningNumbers);
    String getResultKey();
    int getWinningMoney();
}

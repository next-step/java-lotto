package lotto.domain.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public interface WinningStrategy {
    boolean matches(Lotto lotto, Lotto winningNumbers, LottoNumber bonusNumber);
    String getResultKey();
    int getWinningMoney();
}

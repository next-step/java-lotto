package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class WinningNumber {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}

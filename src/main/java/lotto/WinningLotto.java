package lotto;

import exception.LottoException;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;
    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        LottoException.validate(winningNumber);
        LottoException.validateBonusNumber(winningNumber,bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}

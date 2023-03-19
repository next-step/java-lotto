package lotto;

import exception.LottoException;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> winningNumber;
    private final LottoNumber bonusNumber;
    public WinningLotto(List<LottoNumber> winningNumber, int bonusNumber) {
        LottoException.validate(winningNumber);
        LottoException.validateBonusNumber(winningNumber,bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public List<LottoNumber> getWinningNumber() {
        return winningNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}

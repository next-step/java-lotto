package lotto;

import exception.LottoException;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> winningNumber;
    private final int bonusNumber;
    public WinningLotto(List<LottoNumber> winningNumber, int bonusNumber) {
        LottoException.validate(winningNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNumber> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

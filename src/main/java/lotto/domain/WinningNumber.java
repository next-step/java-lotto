package lotto.domain;

import java.util.List;

public class WinningNumber {
    private LottoNumber winningNumber;
    private int bonusNumber;

    public WinningNumber(LottoNumber winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(LottoNumber lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    public int countOfMatch(LottoNumber lottoNumber) {
        return winningNumber.countOfMatch(lottoNumber);
    }
}

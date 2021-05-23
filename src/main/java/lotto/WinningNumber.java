package lotto;

import java.util.List;

public class WinningNumber {
    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        return winningNumbers + "" + bonusNumber + "";
    }
}

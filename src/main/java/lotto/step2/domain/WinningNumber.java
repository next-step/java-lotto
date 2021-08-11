package lotto.step2.domain;

import java.util.List;

public class WinningNumber {
    private List<LottoNumber> winningNumbers;

    public WinningNumber(List<LottoNumber> winningNumbers) {

        this.winningNumbers = winningNumbers;
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}

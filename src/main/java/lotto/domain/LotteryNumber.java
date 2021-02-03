package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LotteryNumber {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public LotteryNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        sortWinningNumber();
    }

    private void sortWinningNumber() {
        Collections.sort(winningNumbers);
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
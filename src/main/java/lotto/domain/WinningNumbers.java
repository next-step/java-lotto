package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;

import java.util.Set;
import java.util.TreeSet;

public class WinningNumbers {

    private final Set<LottoNumber> winningNumbers;

    public WinningNumbers(TreeSet<LottoNumber> winningNumberTreeSet) {
        if (winningNumberTreeSet.size() != LottoMarkingNumbers.LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCount();
        }
        this.winningNumbers = winningNumberTreeSet;
    }

    public boolean isWinningNumber(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}

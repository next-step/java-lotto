package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.exception.InvalidWinningNumbersException;

import java.util.Set;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;

public class WinningNumbers {
    private final Set<LottoNumber> winningNumbers;

    private WinningNumbers(Set<LottoNumber> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(Set<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw InvalidWinningNumbersException.wrongSize();
        }
    }

    public static WinningNumbers valueOf(Set<LottoNumber> lottoNumbers) {
        return new WinningNumbers(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}

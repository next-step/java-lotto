package lotto.domain;

import lotto.utils.InputValidator;

import java.util.Collections;
import java.util.List;

public class LotteryNumber {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public LotteryNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validate(winningNumbers);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        sortWinningNumber();
    }

    private void validate(List<LottoNumber> winningNumbers){
        InputValidator.checkLengthWinningNumbersValidation(winningNumbers.size());
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
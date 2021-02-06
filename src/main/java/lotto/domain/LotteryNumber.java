package lotto.domain;

import lotto.utils.Validator;

import java.util.Collections;
import java.util.List;

public class LotteryNumber {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public LotteryNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validate();
        sortWinningNumber();
    }

    private void validate(){
        Validator.checkLengthLottoNumberSize(winningNumbers.size());
        Validator.checkDuplicatedWinningNumber(winningNumbers);
        Validator.checkWinningNumbersInBonusNumber(winningNumbers, bonusNumber);
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
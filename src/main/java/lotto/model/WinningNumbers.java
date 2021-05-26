package lotto.model;

import lotto.LottoUtil;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparingInt;
import static lotto.common.LottoConstants.WINNING_NUMBER_CREATE_FAIL_MESSAGE;

public class WinningNumbers {
    private final TreeSet<LottoNumber> winningNumbers;

    public WinningNumbers(TreeSet<LottoNumber> winningNumbers) {
        LottoUtil.validateLottoNumbersSize(winningNumbers, WINNING_NUMBER_CREATE_FAIL_MESSAGE);
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers(String number) {
        Set<LottoNumber> lottoNumbers = LottoUtil.stringNumbersToLottoNumbers(number);
        LottoUtil.validateLottoNumbersSize(lottoNumbers, WINNING_NUMBER_CREATE_FAIL_MESSAGE);
        this.winningNumbers = new TreeSet<>(comparingInt(LottoNumber::number));
        this.winningNumbers.addAll(lottoNumbers);
    }

    public TreeSet<LottoNumber> winningNumbers() {
        return winningNumbers;
    }
}

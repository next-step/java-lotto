package lotto.model;

import lotto.LottoUtil;

import java.util.Collections;
import java.util.List;

import static lotto.common.LottoConstants.WINNING_NUMBER_CREATE_FAIL_MESSAGE;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        LottoUtil.validateLottoNumbersSize(winningNumbers, WINNING_NUMBER_CREATE_FAIL_MESSAGE);
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers(String number) {
        this(LottoUtil.stringNumbersToLottoNumbers(number));
    }

    public List<LottoNumber> winningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}

package lotto.model;

import lotto.LottoUtil;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    public static final String WINNING_NUMBER_CREATE_FAIL_MESSAGE = "당첨 번호 생성에 실패 했습니다.";
    public static final String SPLIT_SYMBOL = ",";
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

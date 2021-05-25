package lotto.model;

import lotto.LottoUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.LottoNumbers.LOTTO_NUMBER_COUNT;

public class WinningNumbers {
    public static final String WINNING_NUMBER_CREATE_FAIL_MESSAGE = "당첨 번호 생성에 실패 했습니다.";
    public static final String SPLIT_SYMBOL = ",";
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        validateLottoNumberSize(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers(String number) {
        this(LottoUtil.stringNumbersToLottoNumbers(number));
    }

    private void validateLottoNumberSize(List<LottoNumber> lottoNumbers) {
        if (!(new HashSet<>(lottoNumbers).size() == LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException(WINNING_NUMBER_CREATE_FAIL_MESSAGE);
        }
    }

    public List<LottoNumber> winningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}

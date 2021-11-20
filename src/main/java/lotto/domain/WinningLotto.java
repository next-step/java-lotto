package lotto.domain;

import lotto.exception.WinningLottoCountException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int WINNING_NUMBERS_COUNT = 6;

    private final List<LottoNumber> winningNumbers;

    private WinningLotto(List<LottoNumber> winningNumbers) {
        validateWinningNumbersCount(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbersCount(List<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new WinningLottoCountException(winningNumbers.size());
        }
    }

    public static WinningLotto from(String[] winningNumbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(winningNumbers)
                .mapToInt(Integer::valueOf)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());

        return new WinningLotto(lottoNumbers);
    }
}

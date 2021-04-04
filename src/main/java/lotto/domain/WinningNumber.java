package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final static String DEFAULT_REGEX = ",";

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(String winningNumber, LottoNumber bonusNumber) {
        String[] splitWinningNumbers = winningNumber.split(DEFAULT_REGEX);
        this.winningNumbers = Arrays.stream(splitWinningNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isMatchBonus(LottoNumber lotto) {
        return lotto.isMatchBonus(bonusNumber);
    }
}

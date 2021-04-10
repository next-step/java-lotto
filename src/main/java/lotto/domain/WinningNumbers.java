package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningNumbers(String number, LottoNumber bonusBall) {
        this(winningNumber(number), bonusBall);
    }

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    private static List<LottoNumber> winningNumber(String lottoNumber) {
        return Arrays.stream(lottoNumber.replace(" ", "").split(","))
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }
}

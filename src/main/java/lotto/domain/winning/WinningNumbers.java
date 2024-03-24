package lotto.domain.winning;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class WinningNumbers {

    private List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers fromValues(List<Integer> values) {
        List<LottoNumber> lottoNumbers = values.stream()
            .map(LottoNumber::fromInt)
            .collect(Collectors.toList());
        return new WinningNumbers(lottoNumbers);
    }

    public Grade confirmWinning(Lotto lotto) {
        return Grade.fromCorrectingCount(findNumberThatMatchWinningBall(lotto));
    }

    private int findNumberThatMatchWinningBall(Lotto lotto) {
        return (int) winningNumbers.stream()
            .filter(lotto::contains)
            .count();
    }

    public int size() {
        return winningNumbers.size();
    }
}

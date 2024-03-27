package lotto.domain.winning;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.error.exception.SizeExceedLottoException;

public class WinningNumbers {

    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers fromValues(final List<Integer> values) {
        if (values.size() != 6){
            throw new SizeExceedLottoException(values.size());
        }

        List<LottoNumber> lottoNumbers = values.stream()
            .map(LottoNumber::fromInt)
            .collect(Collectors.toList());
        return new WinningNumbers(lottoNumbers);
    }

    public Grade confirmWinning(final Lotto lotto) {
        return Grade.fromCorrectingCount(findNumberThatMatchWinningBall(lotto));
    }

    private int findNumberThatMatchWinningBall(final Lotto lotto) {
        return (int) winningNumbers.stream()
            .filter(lotto::contains)
            .count();
    }

    public int size() {
        return winningNumbers.size();
    }
}

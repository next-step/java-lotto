package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final Set<LottoBall> winningNumbers;
    private final LottoBall bonusNumber;

    public WinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers.stream().map(LottoBall::getLottoBall).collect(Collectors.toSet());
        this.bonusNumber = LottoBall.getLottoBall(bonusNumber);
    }

    public int matchWinningCount(final Set<Integer> lottoNumbers) {
        Set<LottoBall> compareLottoNumber = lottoNumbers.stream().map(LottoBall::getLottoBall).collect(Collectors.toSet());
        compareLottoNumber.retainAll(winningNumbers);
        return compareLottoNumber.size();
    }

    public boolean isMatchBonus(final int lottoBallsNumber) {
        return bonusNumber == LottoBall.getLottoBall(lottoBallsNumber);
    }
}

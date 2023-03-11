package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumbers {
    private final Set<LottoBall> winningNumbers;
    private final LottoBall bonusNumber;

    public LotteryNumbers(final Set<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers.stream().map(LottoBall::getLottoBall).collect(Collectors.toSet());
        this.bonusNumber = LottoBall.getLottoBall(bonusNumber);
    }

    public int matchWinningCount(final Set<Integer> lottoNumbers) {
        Set<LottoBall> compareLottoNumber = lottoNumbers.stream().map(LottoBall::getLottoBall).collect(Collectors.toSet());
        compareLottoNumber.retainAll(winningNumbers);
        return compareLottoNumber.size();
    }

    public boolean isMatchBonus(final Set<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber.getNumber());
    }


    public WinningGrade getWinningGrade(final Set<Integer> lottoNumbers) {
        return WinningGrade.checkWinningGrade(matchWinningCount(lottoNumbers), isMatchBonus(lottoNumbers));
    }
}

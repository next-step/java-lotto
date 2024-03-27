package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.exception.InvalidBonusNumberException;

public class WinningAndBonusNumbers {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningAndBonusNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningAndBonusNumbers newWinningAndBonusNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateWinningAndBonusNumbers(winningNumbers, bonusNumber);
        return new WinningAndBonusNumbers(winningNumbers, bonusNumber);
    }

    private static void validateWinningAndBonusNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.bonusNumber())) {
            throw new InvalidBonusNumberException(bonusNumber.number());
        }
    }

    public Rank rankOfLotto(Lotto lotto) {
        return Rank.findRank(lotto.countOfMatch(winningNumbers), lotto.contains(bonusNumber));
    }
}

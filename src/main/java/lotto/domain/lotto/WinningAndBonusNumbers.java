package lotto.domain.lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

public class WinningAndBonusNumbers {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningAndBonusNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningAndBonusNumbers newWinningAndBonusNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new WinningAndBonusNumbers(winningNumbers, bonusNumber);
    }


    public Rank rankOfLotto(Lotto lotto) {
        return Rank.findRank(lotto.countOfMatch(winningNumbers), bonusNumber.isMatched(lotto.lottoNumbers()));
    }
}

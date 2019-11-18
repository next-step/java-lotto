package lotto.domain;

import lotto.Rank;

public class WinningRank {

    private static final int BONUS_CHECK = 1;
    private static final int SECOND_LOTTO_WIN_COUNT = 5;

    private WinningLotto winLotto;
    private BonusNumber bonusNumber;

    public WinningRank(int[] winningLotto, int bonusNumber) {
        this.winLotto = new WinningLotto(winningLotto);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    Rank getRankByWinner(int winNumberCount, int bonusNumber) {
        if (winNumberCount == SECOND_LOTTO_WIN_COUNT) {
            return getRankBySecondOrThirdOfWinner(winNumberCount, bonusNumber);
        }
        return Rank.valueOf(winNumberCount, false);
    }

    private Rank getRankBySecondOrThirdOfWinner(int winNumberCount, int bonusNumber) {
        if (bonusNumber == BONUS_CHECK) {
            return Rank.valueOf(winNumberCount, true);
        }
        return Rank.valueOf(winNumberCount, true);
    }

    int checkWinNumber(Lotto lotto) {
        return this.winLotto.checkWinNumber(lotto);
    }

    int getHitCount(Lotto lotto) {
        return this.bonusNumber.getHitCount(lotto);
    }
}

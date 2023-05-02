package step2.domain;

import static step2.domain.Ranking.SECOND;
import static step2.domain.Ranking.THIRD;

import java.util.List;

public class LotteryWin {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LotteryWin(WinningNumbers winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateDuplication(winningNumbers.get(), bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public void confirm(PurchasedLotto lottoList) {
        lottoList.matchRanking(this.winningNumbers);
        List<Lotto> lottos = lottoList.findSecondCandidate();
        for (Lotto lotto : lottos) {
            applySecondOrThird(lotto);
        }
    }

    private void applySecondOrThird(Lotto lotto) {
        if (this.bonusNumber.isContained(lotto)) {
            lotto.rank(SECOND);
            return;
        }
        lotto.rank(THIRD);
    }

    private void validateDuplication(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("이미 존재하는 번호입니다.");
        }
    }
}

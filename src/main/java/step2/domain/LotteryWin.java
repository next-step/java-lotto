package step2.domain;

import static step2.domain.Ranking.FIFTH;
import static step2.domain.Ranking.FIRST;
import static step2.domain.Ranking.FOURTH;
import static step2.domain.Ranking.MISSING;
import static step2.domain.Ranking.SECOND;
import static step2.domain.Ranking.THIRD;

import java.util.List;

public class LotteryWin {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LotteryWin(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void confirm(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            check(lotto);
        }
    }

    public String getRateOfReturn(int money, int winningMoney) {
        return String.format("%.2f", (double) winningMoney / (double) money);
    }

    private void check(Lotto lotto) {
        int matchedCount = getMatchedCount(lotto.getNumbers());

        if (matchedCount == FIFTH.getCountOfMatch()) {
            lotto.rank(FIFTH);
            return;
        }

        if (matchedCount == FOURTH.getCountOfMatch()) {
            lotto.rank(FOURTH);
            return;
        }

        if (isThird(lotto, matchedCount)) {
            lotto.rank(THIRD);
            return;
        }

        if (isSecond(lotto, matchedCount)) {
            lotto.rank(SECOND);
            return;
        }

        if (matchedCount == FIRST.getCountOfMatch()) {
            lotto.rank(FIRST);
            return;
        }

        lotto.rank(MISSING);
    }

    private boolean isThird(Lotto lotto, int matchedCount) {
        return (matchedCount == THIRD.getCountOfMatch())
            && !bonusNumber.isContained(lotto.getNumbers());
    }

    private boolean isSecond(Lotto lotto, int matchedCount) {
        return (matchedCount == THIRD.getCountOfMatch())
            && bonusNumber.isContained(lotto.getNumbers());
    }

    private int getMatchedCount(List<Integer> lotto) {
        return (int) lotto.stream().filter(this.winningNumbers::confirm).count();
    }
}

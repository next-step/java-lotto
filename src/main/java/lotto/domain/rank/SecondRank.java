package lotto.domain.rank;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;

public class SecondRank extends AbstractRank {

    private static final int RANK = 5;

    private int bonusScore = 0;

    public static SecondRank of() {
        return new SecondRank();
    }

    @Override
    public int rank() {
        return RANK;
    }

    @Override
    public int score() {
        return score + bonusScore;
    }

    @Override
    public void apply(WinningLotto winningLotto, Lotto lotto) {
        compareNormalScore(winningLotto, lotto);
    }

    private void compareBonusScore(WinningLotto winningLotto, Lotto lotto) {
        if (winningLotto.compareBonus(lotto) == 1) {
            this.bonusScore += 1;
        }
    }

    private void compareNormalScore(WinningLotto winningLotto, Lotto lotto) {
        if (RANK == winningLotto.compare(lotto)) {
            score += 1;
            compareBonusScore(winningLotto, lotto);
        }
    }

    private int getBonusScore() {
        return bonusScore;
    }

    private int getScoreMinusBonusScore() {
        return Math.max(score - bonusScore, 0);
    }


    @Override
    public String toString() {
        String normalScoreString = String.format("%d개 일치 (%s)-%d개 \n", RANK, Prize.SECOND.price(),
            getScoreMinusBonusScore());
        String bonusScoreString = String.format("%d개 일치, 보너스볼 일치 (%s)-%d개 \n", RANK,
            Prize.BONUS.price(), getBonusScore());
        return normalScoreString + bonusScoreString;
    }
}

package lotto.domain.rank;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class NotRank extends AbstractRank {

    private static final int MIN_RANK = 2;

    public static NotRank of() {
        return new NotRank();
    }

    @Override
    public void apply(WinningLotto winningLotto, Lotto lotto) {
        if (winningLotto.compare(lotto) <= MIN_RANK) {
            score += 1;
        }
    }

    @Override
    public int getRank() {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(MIN_RANK);
    }
}

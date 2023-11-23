package lotto.domain.rank;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;

public class FourthRank extends AbstractRank{

    private static final int RANK = 3;

    public static FourthRank of() {
        return new FourthRank();
    }

    @Override
    public void apply(WinningLotto winningLotto, Lotto lotto) {
        if(RANK == winningLotto.compare(lotto)){
            score += 1;
        }
    }

    @Override
    public int rank() {
        return RANK;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%s)-%d개 \n", RANK, Prize.FOURTH.price(), score());
    }
}

package lotto.domain.rank;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;

public class ThirdRank extends AbstractRank{

    private static final int RANK = 4;

    public static ThirdRank of() {
        return new ThirdRank();
    }

    @Override
    public int rank() {
        return RANK;
    }

    @Override
    public void apply(WinningLotto winningLotto, Lotto lotto) {
        if(RANK == winningLotto.compare(lotto)){
            score += 1;
        }
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%s)-%d개 \n", RANK, Prize.THIRD.price(), score());
    }
}

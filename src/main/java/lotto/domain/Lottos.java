package lotto.domain;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int totalPrize(WinningLotto winningLotto) {
        int totalPrize = 0;
        for (Lotto lotto : lottos) {
            Winning winning = lotto.prize(winningLotto);
            totalPrize += winning.getPrize();
        }
        return totalPrize;
    }

    public int rankCount(WinningLotto winningLotto, int rank) {
        int count = 0;
        for (Lotto lotto : lottos) {
            Winning winning = lotto.rank(winningLotto);
            count = getCount(rank, count, winning);
        }
        return count;
    }

    private int getCount(int rank, int count, Winning winning) {
        if(rank == winning.getRank()) {
            count++;
        }
        return count;
    }
}

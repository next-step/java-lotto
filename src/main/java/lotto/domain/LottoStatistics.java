package lotto.domain;

import java.util.*;

public class LottoStatistics {
    private final LottoWinner winner;

    private LottoStatistics() {
        this.winner = new LottoWinner();
    }

    public static LottoStatistics of() {
        return new LottoStatistics();
    }

    public LottoWinner calculateStats(List<Lotto> lottos, Lotto previousLotto) {
        winner.calculateWinner(lottos, previousLotto);

        return winner;
    }

    public float calculateYield(LottoWinner winner, int price) {
        return winner.calculateYield(winner, price);
    }

    public float calculateYield(List<Lotto> lottos, Lotto previousLotto, int price) {
        return winner.calculateYield(lottos, previousLotto, price);
    }
}

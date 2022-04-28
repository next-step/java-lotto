package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    static Lottos supplyLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoWinner calculateWinner(Lotto previousLotto, int bonusNumber) {
        final Map<LottoWinnerType, Integer> winners = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoWinnerType winnerType = lotto.winLotto(previousLotto, bonusNumber);
            int countOfWinners = winners.get(winnerType) != null ? winners.get(winnerType) : 0;
            winners.put(winnerType, countOfWinners + 1);
        }

        return new LottoWinner(winners);
    }

    public float calculateYield(LottoWinner winners, int price) {
        long profit = 0;
        for (Map.Entry<LottoWinnerType, Integer> winner : winners.getWinners().entrySet()) {
            profit += calculateProfit(winner.getKey(), winner.getValue());
        }

        return (float) profit / price;
    }

    private int calculateProfit(LottoWinnerType winnerType, int countOfLotto) {
        return LottoWinnerType.prize(winnerType) * countOfLotto;
    }
}

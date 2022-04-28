package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class LottoWinner {
    private final Map<LottoWinnerType, Integer> winners;

    LottoWinner(Map<LottoWinnerType, Integer> winners) {
        this.winners = winners;
    }

    public Map<LottoWinnerType, Integer> getWinners() {
        return Collections.unmodifiableMap(winners);
    }

    public float calculateYield(int price) {
        long profit = 0;
        for (Map.Entry<LottoWinnerType, Integer> winner : winners.entrySet()) {
            profit += calculateProfit(winner.getKey(), winner.getValue());
        }

        return (float) profit / price;
    }

    private int calculateProfit(LottoWinnerType winnerType, int countOfLotto) {
        return LottoWinnerType.prize(winnerType) * countOfLotto;
    }
}

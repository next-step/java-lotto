package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinner {
    private final Map<LottoWinnerType, Integer> winners;

    private LottoWinner() {
        this(new HashMap<>());
    }

    public static LottoWinner createLottoMachine() {
        return new LottoWinner();
    }

    LottoWinner(Map<LottoWinnerType, Integer> winners) {
        this.winners = winners;
    }

    public LottoWinner calculateWinner(List<Lotto> lottos, Lotto previousLotto, int bonus) {
        for (Lotto lotto : lottos) {
            LottoWinnerType winnerType = lotto.winLotto(previousLotto, bonus);
            int countOfWinners = winners.get(winnerType) != null ? winners.get(winnerType) : 0;
            winners.put(winnerType, countOfWinners + 1);
        }

        return this;
    }

    public float calculateYield(LottoWinner winners, int price) {
        int profit = 0;
        for (Map.Entry<LottoWinnerType, Integer> winner : winners.getWinners().entrySet()) {
            profit = calculateProfit(profit, winner.getKey(), winner.getValue());
        }

        return (float) profit / price;
    }

    private int calculateProfit(int profit, int countOfDuplicate, boolean isBonus, int countOfLotto) {
        return profit + LottoWinnerType.prize(countOfDuplicate, isBonus) * countOfLotto;
    }

    private int calculateProfit(int profit, LottoWinnerType winnerType, int countOfLotto) {
        return profit + LottoWinnerType.prize(winnerType) * countOfLotto;
    }

    public Map<LottoWinnerType, Integer> getWinners() {
        return Collections.unmodifiableMap(winners);
    }
}

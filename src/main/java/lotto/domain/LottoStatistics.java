package lotto.domain;

import java.util.*;

public class LottoStatistics {
    private final List<Lotto> lottos;
    private final Lotto previousLotto;

    private LottoStatistics(List<Lotto> lottos, Lotto previousLotto) {
        this.lottos = lottos;
        this.previousLotto = previousLotto;
    }

    public static LottoStatistics of(List<Lotto> lottos, Lotto previousLotto) {
        return new LottoStatistics(lottos, previousLotto);
    }

    public LottoWinner calculateStats(List<Lotto> lottos, Lotto previousLotto) {
        LottoWinner lottoWinner = new LottoWinner();
        lottoWinner.calculateWinner(lottos, previousLotto);

        return lottoWinner;
    }

    public float calculateYield(List<Lotto> lottos, Lotto previousLotto, int price) {
        LottoWinner lottoWinner = new LottoWinner();

        return lottoWinner.calculateYield(lottos, previousLotto, price);
    }

    public class LottoWinner {
        private final Map<LottoWinnerType, Integer> winners;

        private LottoWinner() {
            this.winners = new HashMap<>();
        }

        public void calculateWinner(List<Lotto> lottos, Lotto previousLotto) {
            for (Lotto lotto : lottos) {
                int countOfDuplicate = accumulateStats(lotto, previousLotto);
                LottoWinnerType winnerType = LottoWinnerType.valueOf(countOfDuplicate);
                int countOfWinners = winners.get(winnerType) != null ? winners.get(winnerType) : 0;
                winners.put(winnerType, countOfWinners + 1);
            }
        }

        private int accumulateStats(Lotto lotto, Lotto previousLotto) {
            return lotto.countDuplicateValue(previousLotto);
        }

        public float calculateYield(List<Lotto> lottos, Lotto previousLotto, int price) {
            calculateWinner(lottos, previousLotto);

            int profit = 0;
            for (Map.Entry<LottoWinnerType, Integer> winner : winners.entrySet()) {
                profit = calculateProfit(profit, winner.getKey().getCountOfDuplicate(), winner.getValue());
            }

            return (float) profit / price;
        }

        private int calculateProfit(int profit, int countOfDuplicate, int countOfLotto) {
            return profit + LottoWinnerType.prize(countOfDuplicate) * countOfLotto;
        }

        public Map<LottoWinnerType, Integer> getWinners() {
            return Collections.unmodifiableMap(winners);
        }
    }
}

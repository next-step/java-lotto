package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final int LOTTO_DUPLICATE_NUMBER = 7;

    private LottoStatistics() {
    }

    public static int[] calculateStats(List<Lotto> lottos, Lotto previousLotto) {
        int[] stats = new int[LOTTO_DUPLICATE_NUMBER];
        for (Lotto lotto : lottos) {
            stats[accumulateStats(lotto, previousLotto)]++;
        }
        return stats;
    }

    private static int accumulateStats(Lotto lotto, Lotto previousLotto) {
        return lotto.countDuplicateValue(previousLotto);
    }

    public static int calculateYield(List<Lotto> lottos, Lotto previousLotto, int price) {
        int profit = 0;
        int[] stats = calculateStats(lottos, previousLotto);
        for (int i = 0, len = stats.length; i < len; i++) {
            profit = calculateProfit(profit, i, stats[i]);
        }
        return profit / price;
    }

    private static int calculateProfit(int profit, int countOfDuplicate, int countOfLotto) {
        return profit + LottoWinnerType.prize(countOfDuplicate) * countOfLotto;
    }

    public enum LottoWinnerType {
        FIRST_PLACE(6, 2000000000),
        SECOND_PLACE(5, 1500000),
        THIRD_PLACE(4, 50000),
        FOURTH_PLACE(3, 5000),
        NON_WIN(-1, 0);

        private int countOfDuplicate;
        private int prize;

        LottoWinnerType(int countOfDuplicate, int prize) {
            this.countOfDuplicate = countOfDuplicate;
            this.prize = prize;
        }

        private static final Map<Integer, LottoWinnerType> mapToPrize;

        static {
            mapToPrize = new HashMap<>();
            for (LottoWinnerType e : LottoWinnerType.values()) {
                mapToPrize.put(e.countOfDuplicate, e);
            }
        }

        public static int prize(int countOfDuplicate) {
            try {
                return mapToPrize.get(countOfDuplicate).prize;
            } catch (NullPointerException e) {
                return NON_WIN.prize;
            }
        }
    }
}

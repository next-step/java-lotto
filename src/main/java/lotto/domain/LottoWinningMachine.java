package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningMachine {

    private Map<Rank, Integer> rankCounts;

    public LottoWinningMachine() {
        this.rankCounts = new HashMap<>();
    }

    public Map<Rank, Integer> start(Lotto winningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int count = checkCount(winningLotto, lotto);
            Rank rank = Rank.rankByCount(count);
            int countOfRank = getCountOfRank(rank);
            rankCounts.put(rank, countOfRank + 1);
        }

        return rankCounts;
    }

    public int checkCount(Lotto winningLotto, Lotto lotto) {
        int count = 0;

        List<LottoNumber> numbers = lotto.getNumbers();
        List<LottoNumber> winningNumbers = winningLotto.getNumbers();

        for (LottoNumber number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public int getCountOfRank(Rank rank) {
        if (rankCounts.containsKey(rank)) {
            return rankCounts.get(rank);
        }

        return 0;
    }

    public double calculateRateOfResult(Map<Rank, Integer> result, int amount) {
        long sumOfPrizeMoney = 0L;

        for (Map.Entry<Rank, Integer> rankCounts : result.entrySet()) {
            Rank rank = rankCounts.getKey();
            sumOfPrizeMoney += rank.getPrizeMoney() * rankCounts.getValue();
        }

        return new BigDecimal(sumOfPrizeMoney).divide(new BigDecimal(amount), 2, RoundingMode.HALF_UP).doubleValue();
    }
}

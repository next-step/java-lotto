package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningMachine {

    private final Map<Rank, Integer> rankCounts;
    private final Lotto winningLotto;

    public LottoWinningMachine(Lotto winningLotto) {
        this.rankCounts = new HashMap<>();
        this.winningLotto = winningLotto;
    }

    public Map<Rank, Integer> getRankCounts(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchCount(winningLotto);

            Rank rank = Rank.rankByCount(matchCount);

            rankCounts.put(rank, getCountOfRank(rank) + 1);
        }

        return rankCounts;
    }

    private int getCountOfRank(Rank rank) {
        if (rankCounts.containsKey(rank)) {
            return rankCounts.get(rank);
        }

        return 0;
    }

    public double calculateRateOfResult(Map<Rank, Integer> result, int amount) {
        long sumOfPrizeMoney = 0L;

        for (Map.Entry<Rank, Integer> rankCounts : result.entrySet()) {
            Rank rank = rankCounts.getKey();
            sumOfPrizeMoney += (long) rank.getPrizeMoney() * rankCounts.getValue();
        }

        return new BigDecimal(sumOfPrizeMoney).divide(new BigDecimal(amount), 2, RoundingMode.HALF_UP).doubleValue();
    }
}

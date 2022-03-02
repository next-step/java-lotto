package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> lottoResult = new HashMap<>();

    public int getWinProfit() {
        int totalIncome = 0;

        for (Rank rank : Rank.values()) {
            totalIncome += (findStatistics(rank) * rank.getMoney());
        }

        return totalIncome;
    }

    public void matchCounting(int match, boolean bonus) {
        Rank rank = Rank.getReward(match, bonus);

        lottoResult.put(rank, findStatistics(rank) + 1);
    }

    public int findStatistics(Rank rank) {
        return lottoResult.getOrDefault(rank, 0);
    }
}

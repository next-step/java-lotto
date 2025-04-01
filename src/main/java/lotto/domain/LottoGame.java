package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final Map<Rank, Integer> ranks = new HashMap<>();
    private final Profit profit;

    public LottoGame(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.calculateRank(lotto);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        profit = new Profit(ranks, lottos.size());
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public Profit getProfit() {
        return profit;
    }
}

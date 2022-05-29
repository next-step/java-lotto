package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class TotalRank {

    private Map<Rank, Integer> totalRank;

    public TotalRank(WinningLotto winningLotto, Lottos lottos) {
        totalRank = getTotalRank(winningLotto, lottos);
    }

    public Map<Rank, Integer> getTotalRank(WinningLotto winningLotto, Lottos lottos) {
        Map<Rank, Integer> totalLottoRank = new HashMap<>();
        for (Rank value : Rank.values()) {
            totalLottoRank.put(value, 0);
        }

        for (Lotto buyingLotto : lottos.getLottoList()) {
            Rank rank = buyingLotto.getRank(winningLotto);
            totalLottoRank.put(rank, totalLottoRank.get(rank) + 1);
        }

        return totalLottoRank;
    }

    public int count(Rank rank) {
        return totalRank.get(rank);
    }
}

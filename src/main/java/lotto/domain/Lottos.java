package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void checkAllLottosResult(List<Integer> winningNumbers) {
        lottos.forEach((lotto) -> lotto.checkLottoResult(winningNumbers));
    }

    public Map<Rank, Integer> getStatistics() {
        Map<Rank, Integer> statistics = new HashMap<>();
        initializeStatistics(statistics);

        for (Lotto lotto : lottos) {
            Rank rank = lotto.getRank();
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private void initializeStatistics(Map<Rank, Integer> statistics) {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
    }
}

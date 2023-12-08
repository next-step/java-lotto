package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private Map<Rank, Integer> lottoStatistics;
    public LottoStatistics() {
        this.lottoStatistics = new HashMap<>();
        init();
    }

    public Map<Rank, Integer> getLottoStatistics() {
        return Collections.unmodifiableMap(lottoStatistics);
    }
    public void addRank(Rank rank) {
        this.lottoStatistics.compute(rank, (k, v) -> (v == null) ? 1 : v + 1);
    }
    private void init() {
        lottoStatistics.put(Rank.FOURTH, 0);
        lottoStatistics.put(Rank.THIRD, 0);
        lottoStatistics.put(Rank.SECOND, 0);
        lottoStatistics.put(Rank.FIRST, 0);
    }
}

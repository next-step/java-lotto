package lotto.step3.domain;

import java.util.Map;

public class LottoStatistics {
    private Map<Rank,Integer> lottoStatistics;

    public LottoStatistics(Map<Rank, Integer> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }
}

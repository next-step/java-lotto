package lotto.domain;

import java.util.Map;

public class LottoWinningStatistics {
    private Map<LottoRank, Integer> lottoRanks;

    public LottoWinningStatistics(Map<LottoRank, Integer> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public long getWinningMoney() {
        return lottoRanks.entrySet().stream().map(lottoRank -> lottoRank.getKey().getWinningMoney()).reduce(Integer::sum).orElse(0);
    }

    public Map<LottoRank, Integer> getLottoRanks() {
        return lottoRanks;
    }

}

package lotto.domain;

import java.util.Map;

public class WinningResult {
    private Map<LottoRank, Long> lottoResultByRank;

    private WinningResult(Map<LottoRank, Long> lottoResultByRank) {
        this.lottoResultByRank = lottoResultByRank;
    }

    public static WinningResult of(Map<LottoRank, Long> lottoResultByRank) {
        return new WinningResult(lottoResultByRank);
    }

    public double calculateWinningRate() {
        return 0.0d;
    }

    public Long getRankCount(LottoRank rank) {
        return lottoResultByRank.getOrDefault(rank, 0L);
    }
}

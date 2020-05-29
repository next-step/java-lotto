package lotto.domain.winning;

import lotto.domain.lotto.LottoRank;

import java.util.Map;

public class WinningStatistics {
    private final int lottoCount;
    private final Map<LottoRank, Long> lottoRank;

    public WinningStatistics(int lottoCount, Map<LottoRank, Long> lottoRank) {
        this.lottoCount = lottoCount;
        this.lottoRank = createLottoRank(lottoRank);
    }

    private Map<LottoRank, Long> createLottoRank(Map<LottoRank, Long> lottoRank) {
        lottoRank.remove(LottoRank.MISS);

        return lottoRank;
    }

    public Map<LottoRank, Long> getLottoRank() {
        return lottoRank;
    }
}

package lotto.application;

import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;

import java.util.List;

public class LottoResults {
    private final List<LottoRank> lottoRanks;
    private final float profitRate;

    public LottoResults(LottoRanks lottoRanks) {
        this.lottoRanks = lottoRanks.getLottoRanks();
        this.profitRate = lottoRanks.getProfitRate();
    }

    public static LottoResults of(LottoRanks lottoRanks) {
        return new LottoResults(lottoRanks);
    }

    public LottoRanks getLottoRanks() {
        return LottoRanks.of(lottoRanks);
    }

    public float getProfitRate() {
        return profitRate;
    }
}

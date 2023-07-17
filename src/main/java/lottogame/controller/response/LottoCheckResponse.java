package lottogame.controller.response;

import lottogame.domain.LottoRank;

import java.util.Map;
import java.util.Objects;

public class LottoCheckResponse {

    private final double earningRate;
    private final Map<LottoRank, Long> lottoRankCounts;

    public LottoCheckResponse(double earningRate, Map<LottoRank, Long> lottoPrizes) {
        this.earningRate = earningRate;
        this.lottoRankCounts = lottoPrizes;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public Map<LottoRank, Long> getLottoRankCounts() {
        return lottoRankCounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoCheckResponse)) {
            return false;
        }
        LottoCheckResponse that = (LottoCheckResponse) o;
        return Double.compare(that.earningRate, earningRate) == 0 && Objects.equals(lottoRankCounts,
            that.lottoRankCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earningRate, lottoRankCounts);
    }

    @Override
    public String toString() {
        return "LottoCheckResponse{" +
                "earningRate=" + earningRate +
                ", lottoRankCounts=" + lottoRankCounts +
                '}';
    }
}

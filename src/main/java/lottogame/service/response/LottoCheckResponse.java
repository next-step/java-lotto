package lottogame.service.response;

import java.util.Map;
import java.util.Objects;
import lottogame.domain.LottoPrize;

public class LottoCheckResponse {

    private final double earningRate;
    private final Map<LottoPrize, Long> lottoPrizeCounts;

    public LottoCheckResponse(double earningRate, Map<LottoPrize, Long> lottoPrizes) {
        this.earningRate = earningRate;
        this.lottoPrizeCounts = lottoPrizes;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public Map<LottoPrize, Long> getLottoPrizeCounts() {
        return lottoPrizeCounts;
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
        return Double.compare(that.earningRate, earningRate) == 0 && Objects.equals(lottoPrizeCounts,
            that.lottoPrizeCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earningRate, lottoPrizeCounts);
    }

    @Override
    public String toString() {
        return "LottoCheckResponse{" +
                "earningRate=" + earningRate +
                ", lottoPrizeCounts=" + lottoPrizeCounts +
                '}';
    }
}

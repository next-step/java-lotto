package lottogame.service.response;

import java.util.Map;
import java.util.Objects;
import lottogame.domain.LottoPrize;

public class LottoCheckResponse {

    private final double earningRate;
    private final Map<LottoPrize, Integer> lottoPrizes;

    public LottoCheckResponse(double earningRate, Map<LottoPrize, Integer> lottoPrizes) {
        this.earningRate = earningRate;
        this.lottoPrizes = lottoPrizes;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public Map<LottoPrize, Integer> getLottoPrizes() {
        return lottoPrizes;
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
        return Double.compare(that.earningRate, earningRate) == 0 && Objects.equals(lottoPrizes,
            that.lottoPrizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earningRate, lottoPrizes);
    }

    @Override
    public String toString() {
        return "LottoCheckResponse{" +
            "earningRate=" + earningRate +
            ", lottoPrizes=" + lottoPrizes +
            '}';
    }
}

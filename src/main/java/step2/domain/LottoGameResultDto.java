package step2.domain;

import java.util.Map;

public class LottoGameResultDto {

    private final double earningRate;
    private Map<Prize, Integer> prizeResult;

    public LottoGameResultDto(double earningRate, Map<Prize, Integer> prizeResult) {
        this.earningRate = earningRate;
        this.prizeResult = prizeResult;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public int getPrizeCount(Prize prize) {
        return prizeResult.getOrDefault(prize, 0).intValue();
    }

    @Override
    public String toString() {
        return "LottoGameResultDto{" +
            "earningRate=" + earningRate +
            ", prizeResult=" + prizeResult +
            '}';
    }
}

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

    public Map<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }

    @Override
    public String toString() {
        return "LottoGameResultDto{" +
            "earningRate=" + earningRate +
            ", prizeResult=" + prizeResult +
            '}';
    }
}

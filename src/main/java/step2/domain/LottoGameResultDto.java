package step2.domain;

import java.util.Map;

public class LottoGameResultDto {

    private final double earningRate;
    private Map<Integer, Integer> prizeResult;

    public LottoGameResultDto(double earningRate, Map<Integer, Integer> prizeResult) {
        this.earningRate = earningRate;
        this.prizeResult = prizeResult;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public Map<Integer, Integer> getPrizeResult() {
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

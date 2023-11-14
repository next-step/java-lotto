package step3.domain;

import java.util.Map;

public class WinningResult {

    private Map<LottoRank, Integer> result;
    private Double earningRate;

    public WinningResult(Map<LottoRank, Integer> result, Double earningRate) {
        this.result = result;
        this.earningRate = earningRate;
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public Double getEarningRate() {
        return earningRate;
    }
}

package step3.domain;

import java.util.Map;

public class WinningResult {

    private Map<LottoRank, Integer> result;
    private String earningRate;

    public WinningResult(Map<LottoRank, Integer> result, String earningRate) {
        this.result = result;
        this.earningRate = earningRate;
    }
}

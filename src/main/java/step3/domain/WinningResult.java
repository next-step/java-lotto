package step3.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final List<LottoRank> winningLottos;
    private final Double earningRate;
    private final LinkedHashMap<LottoRank, Integer> winningResult;

    public WinningResult(List<LottoRank> result, Double earningRate) {
        winningResult = initResult();
        this.winningLottos = result;
        this.earningRate = earningRate;
    }

    private LinkedHashMap<LottoRank, Integer> initResult() {
        LinkedHashMap<LottoRank, Integer> result = new LinkedHashMap<>();
        Arrays.stream(LottoRank.values()).filter(LottoRank::isNotMiss).forEach(rank -> result.put(rank, 0));
        return result;
    }

    public Map<LottoRank, Integer> winningResult() {
        for (LottoRank lottoRank : winningLottos) {
            winningResult.merge(lottoRank, 1, Integer::sum);
        }
        return winningResult;
    }

    public Double getEarningRate() {
        return earningRate;
    }
}

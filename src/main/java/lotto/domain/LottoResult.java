package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public static double profitPercent(int buyPrice, int resultPrice) {
        return Math.floor((double) resultPrice / buyPrice * 100) / 100.0;
    }

    public void putLottoResult(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}

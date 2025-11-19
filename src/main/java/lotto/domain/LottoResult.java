package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static Map<LottoRank, Integer> lottoResult;

    public static double profitPercent(LottoPrice lottoPrice) {
        return lottoPrice.profitPercent(totalResultPrice());
    }

    private static int totalResultPrice() {
        return lottoResult.keySet().stream()
                .filter(rank -> rank.getMatchCount() != 0)
                .mapToInt(rank -> rank.getPrizeMoney() * lottoResult.get(rank))
                .sum();
    }

    public void putLottoResult(LottoRank lottoRank) {
        lottoResultInit();
        if (lottoRank != null) {
            lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
        }
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public void lottoResultInit() {
        lottoResult = new HashMap<>();
        lottoResult.put(LottoRank.FOURTH, 0);
        lottoResult.put(LottoRank.THIRD, 0);
        lottoResult.put(LottoRank.SECOND, 0);
        lottoResult.put(LottoRank.FIRST, 0);
    }
}

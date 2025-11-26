package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public  LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public int calTotal() {
        int sum = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            sum += result.get(lottoRank) * lottoRank.getPrizeMoney();
        }
        return sum;
    }

    public int getCntByLottoRank(LottoRank lottoRank) {
        return result.get(lottoRank);
    }
}

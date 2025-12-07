package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        this(initResult());
    }

    public LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public Money calTotal() {
        int sum = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            sum += result.get(lottoRank) * lottoRank.getPrizeMoney();
        }
        return new Money(sum);
    }

    public int getCntByLottoRank(LottoRank lottoRank) {
        return result.get(lottoRank);
    }

    private static Map<LottoRank, Integer> initResult() {
        Map<LottoRank, Integer> map = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            map.put(lottoRank, 0);
        }

        return map;
    }

    public void rank(LottoRank rank) {
        if (rank.isAddAble()) {
            result.put(rank, result.get(rank) + 1);
        }
    }
}

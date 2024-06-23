package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> resultMap;

    public LottoResult() {
        resultMap = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void addRank(LottoRank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return resultMap.get(rank);
    }
}

package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;
    private static final Integer ZERO = 0;
    private static final Integer ADD_COUNT = 1;

    public LottoResult() {
        this.lottoResult = new HashMap<>();
    }

    public void addRankCount(Rank rank) {
        lottoResult.put(rank, getRankCount(rank) + ADD_COUNT);
    }

    public Integer getRankCount(Rank rank) {
        return lottoResult.getOrDefault(rank, ZERO);
    }

}

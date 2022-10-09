package lotto.domain;

import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> result;

    private LottoResult(Map<Rank, Integer> result) {
        this.result = result;
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.FIRST, 0);
    }

    public static LottoResult of(Map<Rank, Integer> result) {
        return new LottoResult(result);
    }

    public void put(Rank rank) {
        result.merge(rank, 1, Integer::sum);
    }

    public Integer count(Rank rank) {
        return result.get(rank);
    }

    public Map<Rank, Integer> result() {
        return result;
    }
}

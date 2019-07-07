package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> result = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void putRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public Integer getValue(Rank rank) {
        return result.get(rank);
    }

    public Money getPrize() {
        Money prize = new Money(0);
        for (Rank rank : result.keySet()) {
            prize = prize.sum(rank.prize(result.get(rank)));
        }
        return prize;
    }
}

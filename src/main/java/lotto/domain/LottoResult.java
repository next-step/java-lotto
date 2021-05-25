package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> value = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            value.put(rank, 0);
        }
    }

    public void put(Rank rank) {
        int existingCount = value.get(rank);
        value.put(rank, existingCount + 1);
    }

    public int get(Rank rank) {
        return value.get(rank);
    }
}

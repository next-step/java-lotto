package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    public void addMatch(int match) {
        Rank rank = Rank.from(match);
        lottoResult.put(rank, lottoResult.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return lottoResult.get(rank);
    }

    public long getTotal() {
        return lottoResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().prize() * entry.getValue())
                .sum();
    }
}

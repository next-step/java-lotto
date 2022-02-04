package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Rank;

public class WinningResult {
    private final Map<Rank, Integer> result;

    public WinningResult() {
        this.result = new HashMap<>();
    }

    public void result(List<Rank> ranks) {
        for (Rank rank : ranks) {
            if (result.containsKey(rank)) {
                result.put(rank, result.get(rank) + 1);
                continue;
            }
            result.put(rank, 1);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}

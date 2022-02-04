package lotto.domain;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Rank;

public class WinningResult {

    private final Map<Rank, Integer> result;
    private long winningCash = 0;

    public WinningResult() {
        this.result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void mappingResult(List<Rank> ranks) {
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

    public void calculateTotalPrize() {
        Iterator iterator = result.keySet().iterator();
        while (iterator.hasNext()) {
            Rank rank = (Rank) iterator.next();
            winningCash += result.get(rank) * rank.getPrize();
        }
    }

    public long getWinningCash() {
        return this.winningCash;
    }
}

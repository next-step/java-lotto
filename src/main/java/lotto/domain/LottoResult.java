package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Prize, Integer> prizeCounts;

    public LottoResult(Map<Prize, Integer> prizeCounts) {
        this.prizeCounts = prizeCounts;
    }

    public LottoResult(List<Prize> prizes) {
        Map<Prize, Integer> result = new HashMap<>();
        for (Prize prize: prizes) {
            int count = result.getOrDefault(prize, 0);
            result.put(prize, count + 1);
        }
        prizeCounts = result;
    }

    public int getPrizeCount(Prize prize) {
        return prizeCounts.getOrDefault(prize, 0);
    }
}

package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    public static Map<PrizeRank, Integer> getSummary(List<LottoResult> results) {
        Map<PrizeRank, Integer> summary = new HashMap<>();
        for (LottoResult result : results) {
            summary.put(result.getRank(), summary.getOrDefault(result.getRank(), 0) + 1);
        }

        return summary;
    }
}

package step2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinnersCountManager {
    private final Map<PrizeLevel, Integer> winnersCountMap = new HashMap<>();

    public void recordWinnerCount(PrizeLevel level) {
        winnersCountMap.put(level, winnersCountMap.getOrDefault(level, 0) + 1);
    }

    public int getWinnerCount(PrizeLevel level) {
        return winnersCountMap.getOrDefault(level, 0);
    }

    public Map<PrizeLevel, Integer> getWinnersCountMap() {
        return Collections.unmodifiableMap(winnersCountMap);
    }
}

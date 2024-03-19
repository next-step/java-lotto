package step2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinnersCountManager {
    private final Map<Integer, Integer> winnersCountMap = new HashMap<>();

    public void recordWinnerCount(int count) {
        winnersCountMap.put(count, winnersCountMap.getOrDefault(count, 0) + 1);
    }

    public int getWinnerCount(int count) {
        return winnersCountMap.getOrDefault(count, 0);
    }

    public Map<Integer, Integer> getWinnersCountMap() {
        return Collections.unmodifiableMap(winnersCountMap);
    }
}

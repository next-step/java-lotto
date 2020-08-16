package lotto.domain;

import common.StringResources;

import java.util.HashMap;
import java.util.Map;

public class WinningCountMap {

    private final Map<Integer, Integer> map;

    public WinningCountMap() {
        map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
    }

    public void addCount(int matchCount) {
        map.computeIfPresent(matchCount, (Integer key, Integer value) -> ++value);
    }

    public int get(int matchCount) {
        if (matchCount < 0 || matchCount > 6) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RANGE_RESULT_NUMBER);
        }
        return map.get(matchCount);
    }
}

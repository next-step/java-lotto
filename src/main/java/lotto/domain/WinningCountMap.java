package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningCountMap {

    private final int COUNT_INITIAL_VALUE = 0;

    private final Map<Rank, Integer> map;

    public WinningCountMap() {
        map = new LinkedHashMap<>();
        map.put(Rank.FIFTH, COUNT_INITIAL_VALUE);
        map.put(Rank.FOURTH, COUNT_INITIAL_VALUE);
        map.put(Rank.THIRD, COUNT_INITIAL_VALUE);
        map.put(Rank.SECOND, COUNT_INITIAL_VALUE);
        map.put(Rank.FIRST, COUNT_INITIAL_VALUE);
        Collections.unmodifiableMap(map);
    }

    public void addCount(Rank rank) {
        map.computeIfPresent(rank, (Rank key, Integer value) -> ++value);
    }

    public int getAllWinningMoney() {
        return map.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getMoney())
                .sum();
    }

    public Map<Rank, Integer> getAllData() {
        return map;
    }
}

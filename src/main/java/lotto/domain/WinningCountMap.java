package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningCountMap {

    private final Map<Rank, Integer> map;

    public WinningCountMap() {
        map = new LinkedHashMap<>();
        map.put(Rank.FIFTH, 0);
        map.put(Rank.FOURTH, 0);
        map.put(Rank.THIRD, 0);
        map.put(Rank.SECOND, 0);
        map.put(Rank.FIRST, 0);
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

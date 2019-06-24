package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Aggregate {

    private Map<Integer, Integer> map;

    public Aggregate() {
        map = new HashMap<>();
    }
    public void put(int matchingCount) {
        Integer count = map.getOrDefault(matchingCount, 0);
        map.put(matchingCount, count);
    }

    public int get(int level) {
        return map.get(level);
    }
}

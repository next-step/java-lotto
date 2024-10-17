package lotto;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    Map<Integer, Integer> statistics;

    public Statistics() {
        this.statistics = new HashMap<>(Map.of(
                3, 0,
                4, 0,
                5, 0,
                6, 0
        ));
    }

    public Integer get(Integer key) {
        return statistics.get(key);
    }

    public void put(Integer key, Integer value) {
        this.statistics.put(key, value);
    }
}

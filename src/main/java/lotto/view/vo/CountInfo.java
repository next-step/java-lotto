package lotto.view.vo;

import lotto.enums.Rank;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountInfo {
    Map<Rank, Integer> counts;

    public CountInfo() {
        counts = new LinkedHashMap<>();
    }

    public void put(Rank key, Integer value) {
        this.counts.put(key, value);
    }

    public Map<Rank, Integer> getCounts() {
        return counts;
    }
}

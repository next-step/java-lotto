package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinStatistics {
    private Map<Integer, Integer> matches;
    private final static Map<Integer, Integer> rewordMap = new HashMap(Map.of(3, 5000, 4, 50000, 5, 1500000, 6, 2000000000));

    public WinStatistics() {
        this.matches = new HashMap(Map.of(3, 0, 4, 0, 5, 0, 6, 0));
    }

    public WinStatistics(int three, int four, int five, int six) {
        this.matches = new HashMap(Map.of(3, three, 4, four, 5, five, 6, six));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinStatistics that = (WinStatistics) o;
        return Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }

    public void save(int wins) {
        matches.put(wins, matches.get(wins) + 1);
    }

    public String toPayload() {
        StringBuilder payload = new StringBuilder("");
        for (int key : matches.keySet()) {
            payload.append(key + " matches (₩" + rewordMap.get(key) + "): " + matches.get(key) + "\n");
        }
        return payload.toString();
    }


}

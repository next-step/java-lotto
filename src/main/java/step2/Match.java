package step2;

import java.util.HashMap;
import java.util.Map;

public class Match {
    Map<Integer, Integer> match = new HashMap<>();

    public Match() {
        this.match.put(3, 0);
        this.match.put(4, 0);
        this.match.put(5, 0);
        this.match.put(6, 0);
    }

    public void add(int matchCount) {
        if (this.match.containsKey(matchCount)) {
            final Integer value = this.match.get(matchCount);
            this.match.put(matchCount, value + 1);
        }
    }

    public int sixMatch() {
        return this.match.get(6);
    }

    @Override
    public String toString() {
        return "Match{" +
                "match=" + match +
                '}';
    }
}

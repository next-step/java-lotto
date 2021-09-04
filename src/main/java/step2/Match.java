package step2;

import java.util.HashMap;
import java.util.Map;

public class Match {
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6; // todo enum

    private final Map<Integer, Integer> match = new HashMap<>();

    public Match() {
        this.match.put(THREE, 0);
        this.match.put(FOUR, 0);
        this.match.put(FIVE, 0);
        this.match.put(SIX, 0);
    }

    public void add(int matchCount) {
        if (this.match.containsKey(matchCount)) {
            int value = this.match.get(matchCount);
            this.match.put(matchCount, value + 1);
        }
    }

    public int getThreeMatchCount() {
        return this.match.get(THREE);
    }

    public int getSixMatchCount() {
        return this.match.get(SIX);
    }

    @Override
    public String toString() {
        return "Match{" +
                "match=" + match +
                '}';
    }
}

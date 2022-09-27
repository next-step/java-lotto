package lotto.domain.type;

import java.util.HashMap;
import java.util.Map;

public enum MatchType {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ZERO(0, 0);

    private static final Map<Integer, MatchType> STORE = new HashMap<>();

    static {
        STORE.put(ZERO.matchCount(), ZERO);
        STORE.put(THREE.matchCount(), THREE);
        STORE.put(FOUR.matchCount(), FOUR);
        STORE.put(FIVE.matchCount(), FIVE);
        STORE.put(SIX.matchCount(), SIX);
    }

    public static MatchType findType(int matchCount) {
        return STORE.getOrDefault(matchCount, ZERO);
    }
    private int matchCount;
    private int reward;

    MatchType(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int reward() {
        return this.reward;
    }
}

package lotto.domain.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Match {
    BANG(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private static final Map<Integer, Match> STORE = new HashMap<>();

    static {
        STORE.put(BANG.count(), BANG);
        STORE.put(THREE.count(), THREE);
        STORE.put(FOUR.count(), FOUR);
        STORE.put(FIVE.count(), FIVE);
        STORE.put(SIX.count(), SIX);
    }

    public static Match findType(int matchCount) {
        return STORE.getOrDefault(matchCount, BANG);
    }

    public static List<Match> rewardValues() {
        return Stream.of(Match.values())
                .filter(Match::hasReward)
                .collect(Collectors.toList());
    }

    private final int matchCount;
    private final int reward;

    Match(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int count() {
        return this.matchCount;
    }

    public int reward() {
        return this.reward;
    }

    public boolean hasReward() {
        return !this.equals(BANG);
    }
}

package lotto.domain.type;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);

    private static final Map<Integer, Rank> STORE = new HashMap<>();

    static {
        STORE.put(FIRST.count(), FIRST);
        STORE.put(BONUS.count(), BONUS);
        STORE.put(THIRD.count(), THIRD);
        STORE.put(FOURTH.count(), FOURTH);
        STORE.put(FIFTH.count(), FIFTH);
        STORE.put(MISS.count(), MISS);
    }

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank findRank(int matchCount, boolean matchBonus) {
        if (isBonus(matchCount, matchBonus)) {
            return BONUS;
        }

        return STORE.getOrDefault(matchCount, MISS);
    }

    private static boolean isBonus(int matchCount, boolean matchBonus) {
        return matchBonus && matchCount == BONUS.count();
    }

    public int count() {
        return this.matchCount;
    }

    public int winningMoney() {
        return this.reward;
    }

    public boolean hasWinningMoney() {
        return !this.equals(MISS);
    }
}

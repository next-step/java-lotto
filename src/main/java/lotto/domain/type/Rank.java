package lotto.domain.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    FIFTH(5, 1_500_000),
    FOURTH(4, 50_000),
    SECOND(3, 5_000),
    MISS(0, 0);

    private static final Map<Integer, Rank> STORE = new HashMap<>();

    static {
        STORE.put(MISS.count(), MISS);
        STORE.put(SECOND.count(), SECOND);
        STORE.put(FOURTH.count(), FOURTH);
        STORE.put(FIFTH.count(), FIFTH);
        STORE.put(FIRST.count(), FIRST);
    }

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank findRank(int matchCount) {
        return STORE.getOrDefault(matchCount, MISS);
    }

    public static List<Rank> winningMoneyValues() {
        return Stream.of(Rank.values())
                .filter(Rank::hasWinningMoney)
                .collect(Collectors.toList());
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

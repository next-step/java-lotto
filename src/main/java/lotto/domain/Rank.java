package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, 2000000000, (matchCount, matchBonus) -> (matchCount == 6)),
    SECOND(5, 30000000, (matchCount, matchBonus) -> (matchCount == 5 && matchBonus)),
    THIRD(5, 1500000, (matchCount, matchBonus) -> (matchCount == 5 && !matchBonus)),
    FOURTH(4, 50000, (matchCount, matchBonus) -> (matchCount == 4)),
    FIFTH(3, 5000, (matchCount, matchBonus) -> (matchCount == 3));

    private final int matchCount;
    private final int reward;
    private final BiFunction<Integer, Boolean, Boolean> condition;

    Rank(int matchCount, int reward, BiFunction<Integer, Boolean, Boolean> condition) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.condition = condition;
    }

    static Rank find(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.apply(matchCount, matchBonus))
                .findFirst()
                .orElse(null);
    }

    int totalReward(int count) {
        return this.reward * count;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int reward() {
        return this.reward;
    }
}

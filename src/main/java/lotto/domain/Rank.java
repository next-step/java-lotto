package lotto.domain;

import java.util.*;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false)
    ;

    private final int matchCount;
    private final int prize;
    private final boolean bonus;

    Rank(int matchCount, int prize, boolean bonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(it -> it.matchCount == matchCount)
                .filter(it -> it.bonus == matchBonus)
                .findFirst().orElse(MISS);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}

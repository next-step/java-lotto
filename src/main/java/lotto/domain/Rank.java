package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(Money.from(0), 2),
    FIFTH(Money.from(5_000), 3),
    FOURTH(Money.from(50_000), 4),
    THIRD(Money.from(1_500_000), 5),
    SECOND(Money.from(30_000_000), 5),
    FIRST(Money.from(2_000_000_000), 6);

    private final Money reward;
    private final int matches;

    Rank(Money reward, int matches) {
        this.reward = reward;
        this.matches = matches;
    }

    public Money getReward() {
        return reward;
    }

    public int getMatches() {
        return matches;
    }

    public static Rank calculate(int matches, boolean bonus) {
        if (isSecond(matches, bonus)) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matches == matches)
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isSecond(int matches, boolean bonus) {
        return SECOND.matches == matches && bonus;
    }
}

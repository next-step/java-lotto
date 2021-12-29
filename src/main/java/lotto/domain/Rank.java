package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Rank {
    NONE(Money.from(0), 0, match -> match < 3),
    FOURTH(Money.from(5_000), 3, match -> match == 3),
    THIRD(Money.from(50_000), 4, match -> match == 4),
    SECOND(Money.from(1_500_000), 5, match -> match == 5),
    FIRST(Money.from(2_000_000_000), 6, match -> match == 6);

    private final Money reward;
    private final int matches;
    private final Predicate<Integer> isMatched;

    Rank(Money reward, int matches, Predicate<Integer> isMatched) {
        this.reward = reward;
        this.matches = matches;
        this.isMatched = isMatched;
    }

    public Money getReward() {
        return reward;
    }

    public static Rank calculate(int matches) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatched.test(matches))
                .findFirst()
                .orElse(NONE);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%s)", matches, reward);
    }
}

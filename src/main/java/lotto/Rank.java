package lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int countOfMatch;
    private final int reward;

    Rank(int countOfMatch, int reward) {
        this.countOfMatch = countOfMatch;
        this.reward = reward;
    }

    public static List<Rank> getRanks() {
        return Stream.of(values())
                .filter(rank -> rank != NONE)
                .collect(Collectors.toList());
    }

    public static Rank findRank(int countOfMatch) {
        return Stream.of(values())
                .filter(match(countOfMatch))
                .findAny()
                .orElse(NONE);
    }

    public static int findReward(int countOfMatch) {
        return Stream.of(values())
                .filter(match(countOfMatch))
                .findAny()
                .orElse(NONE)
                .reward;
    }

    private static Predicate<Rank> match(int countOfMatch) {
        return rank -> rank.countOfMatch == countOfMatch;
    }

    public int getReward() {
        return reward;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}

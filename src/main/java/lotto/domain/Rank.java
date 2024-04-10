package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

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


    public static Rank findRank(int countOfMatch, boolean bonusNumber) {
        if (countOfMatch == 5 & bonusNumber) {
            return SECOND;
        }
        return Stream.of(values())
                .filter(match(countOfMatch))
                .findAny()
                .orElse(NONE);
    }

    public static int findReward(int countOfMatch, boolean bonusNumber) {
        if (countOfMatch == 5 && bonusNumber) {
            return SECOND.reward;
        }
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

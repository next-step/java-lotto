package step2.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISSING(0, 0);


    private final int countOfMatch;
    private final int winningMoney;

    Ranking(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Ranking match(int countOfMatch) {
        Ranking[] values = Ranking.values();

        Optional<Ranking> ranking = Arrays.stream(values)
            .filter(rank -> isMatching(countOfMatch, rank))
            .findFirst();

        return ranking.orElse(MISSING);
    }

    public static Ranking match2(int countOfMatch, boolean isContained) {
        Ranking[] values = Ranking.values();

        Optional<Ranking> ranking = Arrays.stream(values)
            .filter(rank -> isMatching(countOfMatch, rank))
            .findFirst();

        if (ranking.isPresent()) {
            return isSecond(isContained, ranking.get());
        }

        return MISSING;
    }

    private static Ranking applyRank(boolean isContained, Ranking rank) {
        if (rank == SECOND && isContained) {
            return SECOND;
        }

        if (rank == SECOND) {
            return THIRD;
        }

        return rank;
    }

    private static boolean isMatching(int countOfMatch, Ranking rank) {
        return rank.getCountOfMatch() == countOfMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

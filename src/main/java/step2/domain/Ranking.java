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
            .filter(rank -> rank.getCountOfMatch() == countOfMatch)
            .findFirst();

        return ranking.orElse(MISSING);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

package lotto.domain.model;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final Map<Integer, Rank> countToRank = Stream.of(values())
            .collect(toMap(Rank::getCountOfMatch, e -> e));

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        if (countOfMatch < FIFTH.countOfMatch) {
            return MISS;
        }
        return countToRank.get(countOfMatch);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(final int countOfMatch, final int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    @SuppressWarnings("PointlessBooleanExpression")
    public static Rank valueOf(final int countOfMatch, final boolean isMatchBonus) {

        final List<Rank> ranks = Arrays.stream(values())
                .filter(rank -> eqCountOfMatch(rank.getCountOfMatch(), countOfMatch))
                .filter(rank -> isMatchBonus || rank.equals(Rank.SECOND) == false)
                .collect(toList());

        return hasRanks(ranks)
                ? returnFirstDataInRanks(ranks)
                : Rank.MISS;
    }

    private static Rank returnFirstDataInRanks(final List<Rank> ranks) {
        return ranks.get(0);
    }

    private static boolean hasRanks(final List<Rank> ranks) {
        return ranks.size() > 0;
    }

    private static boolean eqCountOfMatch(final int sourceCountOfMatch, final int targetCountOfMatch) {
        return sourceCountOfMatch == targetCountOfMatch;
    }

}
package lotto.domain.model.result;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {
    MISS(0, 0, stats -> stats.isLessThan(3)),
    FIFTH(3, 5_000, stats -> stats.countEquals(3)),
    FOURTH(4, 50_000, stats -> stats.countEquals(4)),
    THIRD(5, 1_500_000, stats -> stats.countEquals(5) && !stats.isMatchBonus()),
    SECOND(5, 30_000_000, stats -> stats.countEquals(5) && stats.isMatchBonus()),
    FIRST(6, 2_000_000_000, stats -> stats.countEquals(6));

    private final int countOfMatch;
    private final int winningMoney;
    private final Predicate<MatchStats> predicate;

    LottoRank(int countOfMatch, int winningMoney, Predicate<MatchStats> predicate) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.predicate = predicate;
    }

    public static LottoRank of(MatchStats matchStats) {
        return Arrays.stream(values())
                .filter(rank -> rank.predicate.test(matchStats))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

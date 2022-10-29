package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    MISS(0, 0L, (matchCount, hasBonus) -> matchCount < 3),
    FIFTH(3, 5_000L, (matchCount, hasBonus) -> matchCount == 3),
    FOURTH(4, 50_000L, (matchCount, hasBonus) -> matchCount == 4),
    THIRD(5, 1_500_000L, (matchCount, hasBonus) -> matchCount == 5 && !hasBonus),
    SECOND(5, 30_000_000L, (matchCount, hasBonus) -> matchCount == 5 && hasBonus),
    FIRST(6, 2_000_000_000L, (matchCount, hasBonus) -> matchCount == 6);

    private final int countOfMatch;
    private final long winningMoney;
    private final BiPredicate<Integer, Boolean> rankChecker;

    LottoRank(int countOfMatch, long winningMoney, BiPredicate<Integer, Boolean> rankChecker) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.rankChecker = rankChecker;
    }

    public static LottoRank win(int countOfMatch, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.rankChecker.test(countOfMatch, hasBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}

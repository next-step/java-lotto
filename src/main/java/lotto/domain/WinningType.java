package lotto.domain;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum WinningType {
    FIRST(Money.from(2_000_000_000L), 6, (matchCount, isBonus) -> matchCount == 6),
    SECOND(Money.from(30_000_000L), 5, (matchCount, isBonus) -> matchCount == 5 && isBonus),
    THIRD(Money.from(1_500_000L), 5, (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    FOURTH(Money.from(50_000L), 4, (matchCount, isBonus) -> matchCount == 4),
    FIFTH(Money.from(5_000L), 3, (matchCount, isBonus) -> matchCount == 3),
    NOTHING(Money.from(0L), 0, (matchCount, isBonus) -> matchCount < 3);

    private final Money prize;
    private final int matchCount;
    private final BiFunction<Integer, Boolean, Boolean> winningRule;

    WinningType(Money prize, int matchCount, BiFunction<Integer, Boolean, Boolean> winningRule) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.winningRule = winningRule;
    }

    public static WinningType findType(int countOfMatch, boolean isBonusMatch) {
        return Stream.of(values())
                .filter(winningType -> winningType.winningRule.apply(countOfMatch, isBonusMatch))
                .findFirst()
                .orElse(NOTHING);
    }

    public Money getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}

package Lotto.domain;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum WinningType {
    FIRST(6, 2_000_000_000, (countOfMatch, hasBonusNumber) -> countOfMatch == 6),
    SECOND(5, 30_000_000, (countOfMatch, hasBonusNumber) -> countOfMatch == 5 && hasBonusNumber),
    THIRD(5, 1_500_000, (countOfMatch, hasBonusNumber) -> countOfMatch == 5 && !hasBonusNumber),
    FOURTH(4, 50_000, (countOfMatch, hasBonusNumber) -> countOfMatch == 4),
    FIFTH(3, 5_000, (countOfMatch, hasBonusNumber) -> countOfMatch == 3),
    MISS(0, 0, (countOfMatch, hasBonusNumber) -> countOfMatch < 3);

    private final int countOfMatch;
    private final int winningMoney;
    private final BiFunction<Integer, Boolean, Boolean> isMatch;

    WinningType(final int countOfMatch,
                final int winningMoney,
                final BiFunction<Integer, Boolean, Boolean> isMatch) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isMatch = isMatch;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public static WinningType valueOf(final int countOfMatch, final boolean hasBonusNumber) {
        return Stream.of(WinningType.values())
                .filter(value -> value.isMatch.apply(countOfMatch, hasBonusNumber))
                .findFirst()
                .orElse(MISS);
    }
}

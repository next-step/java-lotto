package step5.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(2_000_000_000, 6L, (countOfMatch, matchBonus) -> countOfMatch == 6),
    SECOND(30_000_000, 5L, (countOfMatch, matchBonus) -> countOfMatch == 5 && matchBonus),
    THIRD(1_500_000, 5L, (countOfMatch, matchBonus) -> countOfMatch == 5 && !matchBonus),
    FOURTH(50_000, 4L, (countOfMatch, matchBonus) -> countOfMatch == 4),
    FIFTH(5_000, 3L, (countOfMatch, matchBonus) -> countOfMatch == 3),
    MISS(0, 0L, (countOfMatch, matchBonus) -> countOfMatch == 0);

    private final int winningMoney;
    private final BiPredicate<Long, Boolean> condition;
    private final Long countOfMatch;

    Rank(final int winningMoney, Long countOfMatch, final BiPredicate<Long, Boolean> condition) {
        this.winningMoney = winningMoney;
        this.condition = condition;
        this.countOfMatch = countOfMatch;
    }

    public Long getCountOfMatch() {
        return countOfMatch;
    }

    public static Rank valueOf(Long countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
            .filter(rank -> rank.condition.test(countOfMatch, matchBonus))
            .findFirst()
            .orElse(MISS);
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
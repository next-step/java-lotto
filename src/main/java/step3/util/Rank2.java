package step3.util;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank2 {
    FIRST(2_000_000_000, (countOfMatch, matchBonus) -> countOfMatch == 6),
    SECOND(30_000_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && matchBonus),
    THIRD(1_500_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && !matchBonus),
    FOURTH(50_000, (countOfMatch, matchBonus) -> countOfMatch == 4),
    FIFTH(5_000, (countOfMatch, matchBonus) -> countOfMatch == 3),
    MISS(0, (countOfMatch, matchBonus) -> countOfMatch == 0);

    private final int winningMoney;
    private final BiPredicate<Integer, Boolean> condition;

    Rank2(final int winningMoney,
         final BiPredicate<Integer, Boolean> condition) {
        this.winningMoney = winningMoney;
        this.condition = condition;
    }

    public static Rank2 valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.condition.test(countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }
}

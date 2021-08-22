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

    private int winningMoney;
    private BiPredicate<Integer, Boolean> condition;

    private Rank2(int winningMoney, boolean matchBonus) {
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.condition.apply(countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }
}

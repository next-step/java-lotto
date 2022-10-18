package step2.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {
    FIRST(6,
            2_000_000_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 6
    ),
    SECOND(5,
            30_000_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 5 && matchBonus
    ),
    THIRD(5,
            1_500_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 5 && !matchBonus
    ),
    FOURTH(4,
            50_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 4
    ),
    FIFTH(3,
            5_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 3
    ),
    MISS(0,
            0,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch < 3
    );

    private final int countOfMatch;

    private final int winningMoney;

    private final BiFunction<Integer, Boolean, Boolean> createFunction;

    Rank(int countOfMatch, int winningMoney, BiFunction<Integer, Boolean, Boolean> createFunction) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.createFunction = createFunction;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.createFunction.apply(countOfMatch, matchBonus))
                .findFirst()
                .orElseThrow();
    }
}

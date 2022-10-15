package step2.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {
    FIRST(2_000_000_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 6,
            "6개 일치"
    ),
    SECOND(30_000_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 5 && matchBonus,
            "5개 일치, 보너스 볼 일치"
    ),
    THIRD(1_500_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 5 && !matchBonus,
            "5개 일치"
    ),
    FOURTH(50_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 4,
            "4개 일치"
    ),
    FIFTH(5_000,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch == 3,
            "3개 일치"
    ),
    MISS(0,
            (Integer countOfMatch, Boolean matchBonus) -> countOfMatch < 3,
            "일치하지 않음"
    );

    private final int winningMoney;

    private final BiFunction<Integer, Boolean, Boolean> createFunction;

    private final String matchMessage;

    Rank(int winningMoney, BiFunction<Integer, Boolean, Boolean> createFunction, String matchMessage) {
        this.winningMoney = winningMoney;
        this.createFunction = createFunction;
        this.matchMessage = matchMessage;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMatchMessage() {
        return matchMessage;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.createFunction.apply(countOfMatch, matchBonus))
                .findFirst()
                .orElseThrow();
    }
}

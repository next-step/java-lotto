package lotto.model;

import java.util.Arrays;
import java.util.Objects;


public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean matchBonus;

    private Rank(int countOfMatch, int winningMoney, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 3) {
            return Rank.MISS;
        }
        return Arrays.stream(values())
                .filter(rank -> Objects.equals(rank.matchBonus, matchBonus) && Objects.equals(rank.countOfMatch, countOfMatch))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("맞는 번호의 개수가 맞지 않습니다."));
    }
}

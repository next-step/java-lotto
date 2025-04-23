package lotto.domain;

import java.util.Arrays;

public enum Rank implements RankMatcher {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int countOfMatch;
    private final boolean matchBonus;
    private final int winningMoney;

    Rank(int countOfMatch, boolean matchBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank fromMatchCountAndBonus(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < 0 || countOfMatch > 6) {
            throw new IllegalArgumentException("일치하는 번호는 최대 6개까지만 가능합니다.");
        }

        return Arrays.stream(values()).filter(rank -> rank.match(countOfMatch, matchBonus)).findFirst().orElse(MISS);
    }

    @Override
    public boolean match(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 6) {
            return this == FIRST;
        }
        if (countOfMatch == 5) {
            return (this == SECOND && matchBonus) || (this == THIRD && !matchBonus);
        }
        if (countOfMatch == 4) {
            return this == FOURTH;
        }
        if (countOfMatch == 3) {
            return this == FIFTH;
        }
        return this == MISS;
    }

}

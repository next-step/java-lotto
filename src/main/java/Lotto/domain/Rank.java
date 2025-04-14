package Lotto.domain;

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

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank fromMatchCountAndBonus(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values()).filter(rank -> rank.match(countOfMatch, matchBonus)).findFirst().orElse(MISS);
    }

    @Override
    public boolean match(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 6) {
            return true; // 6개 번호가 맞으면 보너스 번호는 상관없음
        }
        return this.countOfMatch == countOfMatch && this.matchBonus == matchBonus;
    }

}

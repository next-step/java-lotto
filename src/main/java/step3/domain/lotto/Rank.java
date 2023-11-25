package step3.domain.lotto;

import java.util.Arrays;

public enum Rank {

    NO_MATCH(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private boolean isSameCountOfMatch(final int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public boolean isNoMatch() {
        return this == NO_MATCH;
    }

    public boolean isCountOfMatchFive() {
        return this.countOfMatch == 5;
    }

    public static Rank findRank(final int countOfMatch, boolean hasBonusNumber) {
        Rank rank = Arrays.stream(Rank.values())
                .filter(r -> r.isSameCountOfMatch(countOfMatch))
                .findFirst()
                .orElse(NO_MATCH);
        if (rank.isCountOfMatchFive() && hasBonusNumber) {
            return Rank.SECOND;
        }
        return rank;
    }

    @Override
    public String toString() {
        if (this == Rank.SECOND) {
            return this.countOfMatch + "개 일치, 보너스 볼 일치 (" + this.winningMoney + "원)";
        }
        return this.countOfMatch + "개 일치 (" + this.winningMoney + "원)";
    }
}

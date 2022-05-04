package autolotto.domain;

import autolotto.constant.Rank;

import java.util.Objects;

public class Result {
    private final int countOfMatch;
    private final boolean hasBonusBall;
    private int winners;

    public Result(int countOfMatch, boolean hasBonusBall) {
        this(countOfMatch, hasBonusBall, 0);
    }

    private Result(int countOfMatch, boolean hasBonusBall, int winners) {
        this.countOfMatch = countOfMatch;
        this.hasBonusBall = hasBonusBall;
        this.winners = winners;
    }

    public boolean isMatch(int numberOfWins) {
        return this.countOfMatch == numberOfWins;
    }

    public void plusWinners() {
        winners++;
    }

    public long prize() {
        long prize = Rank.find(countOfMatch, hasBonusBall)
                .map(Rank::getWinningMoney)
                .orElse(0L);
        return prize * winners;
    }

    public int getWinners() {
        return winners;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean hasBonusBall() {
        return hasBonusBall;
    }

    public boolean checkBonus(boolean isBonus) {
        return this.hasBonusBall == isBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return getCountOfMatch() == result.getCountOfMatch() && hasBonusBall == result.hasBonusBall && getWinners() == result.getWinners();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountOfMatch(), hasBonusBall, getWinners());
    }
}

package autolotto.domain;

import autolotto.constant.Rank;

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
}

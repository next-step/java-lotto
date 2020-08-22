package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4,false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private int countOfMatch;
    private boolean isMatchBonusBall;
    private int winningMoney;

    Rank(int countOfMatch, boolean isMatchBonusBall, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.isMatchBonusBall = isMatchBonusBall;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isMatchBonusBall() {
        return isMatchBonusBall;
    }

    public static Rank getRankByCountOfMatchAndBonusBall(int count, boolean isMatchBonusBall) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getCountOfMatch() == count)
                .filter(rank -> rank.isMatchBonusBall == isMatchBonusBall)
                .findAny().orElse(Rank.MISS);
    }

    public static List<Rank> getHasBonusBallRanks() {
        return Arrays.stream(Rank.values())
                .filter(Rank::isMatchBonusBall)
                .collect(Collectors.toList());
    }
}

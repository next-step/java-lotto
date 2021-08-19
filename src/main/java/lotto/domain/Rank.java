package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public void setCountOfMatch(int countOfMatch) {
        this.countOfMatch = countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public void setWinningMoney(int winningMoney) {
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

}

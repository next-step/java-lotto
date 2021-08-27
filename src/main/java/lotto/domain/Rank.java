package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean isBonusNumber;

    private Rank(int countOfMatch, int winningMoney, boolean isBonusNumber) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isBonusNumber = isBonusNumber;
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

    public boolean isBonusNumber() {
        return isBonusNumber;
    }

    public static Rank valueOf(int countOfMatch, boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getCountOfMatch() == countOfMatch
                        && lottoRank.isBonusNumber() == bonusNumber)
                .findFirst()
                .orElse(MISS);
    }

}

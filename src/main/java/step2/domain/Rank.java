package step2.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    // SECOND(5, 30000000), // 보너스볼 등장 미션부터 활용
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private long countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank getRank(long countOfMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }
}

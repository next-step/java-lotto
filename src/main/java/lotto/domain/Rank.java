package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FISRT(6,2_000_000_000),
    SECOND(5,1_150_000),
    THIRD(4,50_000),
    FOURTH(3,5_000),
    MISS(0,0);

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank of(int countOfMatch){
        if (countOfMatch < WINNING_MIN_COUNT){
            return MISS;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않습니다"));
    }
}

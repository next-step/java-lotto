package step3;

import java.util.Arrays;

public enum Prize {

    FIRST(7, 2_000_000_000),
    SECOND(6, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Prize(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Prize findByCountOfMatch(int countOfMatch){
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

}

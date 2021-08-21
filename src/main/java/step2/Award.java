package step2;

import java.util.Arrays;

public enum Award {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Award(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Award valueOf(int countOfMatch) {
        return Arrays.stream(Award.values())
                .filter(each -> each.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 countOfMatch가 없습니다."))
                ;
    }
}

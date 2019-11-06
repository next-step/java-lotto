package lottery.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    FAIL(0, 0);

    private int matchedNumber;
    private int winMoney;

    Prize(int matchedNumber, int winMoney) {
        this.matchedNumber = matchedNumber;
        this.winMoney = winMoney;
    }

    public static Prize getPrize(int matchedCount) {
        if (matchedCount > 6 || matchedCount < 0) {
            throw new IllegalArgumentException("맞춘 숫자의 개수는 최소 1개, 최대 6개입니다.");
        }

        return Arrays.stream(Prize.values())
                     .filter(prize -> matchedCount == prize.getMatchedNumber())
                     .findFirst()
                     .orElse(FAIL);
    }

    public static boolean isFail(Prize prize) {
        return prize.equals(FAIL);
    }


    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getWinMoney() {
        return winMoney;
    }
}

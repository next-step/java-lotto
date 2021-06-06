package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1500000, "5개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    FIFTH(3, 5000, "3개 일치"),
    MISS(0, 0, "꽝");

    private static final int WINNING_MIN_COUNT = 3;
    private static final String ERROR_VALUE_MSG = "값이 잘못되었습니다. 다시 한번 확인해주세요.";

    private int matchCount, money;
    private String message;

    Rank(int winningCount, int money, String message) {
        this.matchCount = winningCount;
        this.money = money;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }

    public static Rank getRank(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .filter(rank -> isBonusMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_VALUE_MSG));
    }

}

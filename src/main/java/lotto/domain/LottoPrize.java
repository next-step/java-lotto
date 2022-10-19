package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    NOT_SAME(0, 0),
    SAME_THREE(3, 5000),
    SAME_FOUR(4, 50000),
    SAME_FIVE(5, 1500000),
    SAME_SIX(6, 2000000000);

    private final int match;
    private final int money;

    LottoPrize(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

    public static LottoPrize win(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.match == matchCount)
                .findFirst()
                .orElse(NOT_SAME);
    }
}

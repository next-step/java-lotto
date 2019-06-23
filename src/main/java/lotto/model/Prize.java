package lotto.model;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Prize(int matchCount, int money) {
        this.matchCount = matchCount;
        this.prize = money;
    }

    public static Prize of(int matchCount) {
        Prize result = Arrays.stream(Prize.values())
                .filter(prize1 -> prize1.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);

        return result;
    }

    public static Prize of(Lotto lotto, Lotto winningLotto) {

        int matchCount = lotto.matchCount(winningLotto);

        Prize result = Arrays.stream(Prize.values())
                .filter(prize1 -> prize1.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);

        return result;
    }

}

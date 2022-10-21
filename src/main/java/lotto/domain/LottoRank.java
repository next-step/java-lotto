package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int match;
    private final int money;

    LottoRank(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

    public static LottoRank win(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.match == matchCount)
                .findFirst()
                .orElse(MISS);
    }
}

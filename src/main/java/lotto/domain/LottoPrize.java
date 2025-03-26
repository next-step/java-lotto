package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final Integer match;
    private final Integer prize;

    LottoPrize(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public Integer getPrize() {
        return prize;
    }

    public static LottoPrize from(int match) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.match.equals(match))
                .findFirst()
                .orElse(null);
    }

}

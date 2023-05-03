package step2.domain.vo;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NONE(0, 0);

    private final int prize;
    private final int prizeCount;

    LottoPrize(int prize, int prizeCount) {
        this.prize = prize;
        this.prizeCount = prizeCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrize prize(int count) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.prizeCount == count)
                .findFirst()
                .orElse(LottoPrize.NONE);
    }
}

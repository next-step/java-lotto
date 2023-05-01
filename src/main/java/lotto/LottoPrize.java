package lotto;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);


    private final int matchCount;
    private final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static int findPrize(int matchCount) {
        LottoPrize lottoPrize = Arrays.stream(values())
                .filter(item -> item.matchCount == matchCount)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        return lottoPrize.prize;
    }
}

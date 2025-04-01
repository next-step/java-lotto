package autoLotto;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    NONE(-1, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchedCount;
    private final int prize;

    LottoPrize(int matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrize valueOf(int matchedCount) {
        return Arrays.stream(values())
                     .filter(prize -> prize.getMatchedCount() == matchedCount)
                     .findFirst()
                     .orElse(NONE);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchedCount, prize);
    }
}

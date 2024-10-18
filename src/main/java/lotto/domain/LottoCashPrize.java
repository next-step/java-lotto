package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoCashPrize {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NO_PRIZE(0, 0, false);

    private final int matchedCount;
    private final int prize;
    private final boolean hasBonus;

    LottoCashPrize(int matchedCount, int prize, boolean hasBonus) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public static LottoCashPrize from(int matchedCount, boolean hasBonus) {
        return Stream.of(values())
                .filter(prize -> {
                    if (matchedCount == 5) {
                        return prize.getMatchedCount() == matchedCount && prize.hasBonus() == hasBonus;
                    }

                    return prize.getMatchedCount() == matchedCount;
                })
                .findFirst()
                .orElse(LottoCashPrize.NO_PRIZE);
    }

    public static List<LottoCashPrize> getValuablePrizes() {
        return Stream.of(values()).filter(prize -> prize != LottoCashPrize.NO_PRIZE).collect(Collectors.toList());
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}

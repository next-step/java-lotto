package step2.domain;

import java.util.Arrays;

public enum LottoTier {

    FIRST(6, 2_000_000_000),
    SECOND(5, 150_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private int matchedNumberCount;
    private int prize;

    LottoTier(int matchedNumberCount, int prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.prize = prize;
    }

    public int calculatePrize(int count) {
        return count * prize;
    }

    public static LottoTier getTier(int matchedNumberCount) {
        return Arrays.stream(values())
                .filter(tier -> tier.matchedNumberCount == matchedNumberCount)
                .findFirst()
                .orElse(NONE);
    }
}

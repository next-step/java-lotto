package step2.domain;

import java.util.Arrays;

public enum LottoTier {

    FIRST(6, 2000000000),
    SECOND(5, 150000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
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

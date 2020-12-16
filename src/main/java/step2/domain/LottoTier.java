package step2.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoTier {
    FIRST(6, 2_000_000_000, matchingCount -> matchingCount == 6),
    SECOND(5, 1_500_000, matchingCount -> matchingCount == 5),
    THIRD(4, 50_000, matchingCount -> matchingCount == 4),
    FOURTH(3,5_000, matchingCount -> matchingCount == 3),
    NONE(0,0, matchingCount -> matchingCount < 3);

    private final long matchingCount;
    private final int prize;
    private final Function<Long, Boolean> isWinning;

    LottoTier(long matchingCount, int prize, Function<Long, Boolean> isWinning) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.isWinning = isWinning;
    }

    public boolean from(long matchingCount) {
        return isWinning.apply(matchingCount);
    }

    public static LottoTier getTier(long matchingCount) {
        return Arrays.stream(values())
                .filter(tier -> tier.from(matchingCount))
                .findFirst()
                .orElse(NONE);
    }

    public Integer calculatePrize(Integer count) {
        return count * prize;
    }

    public long getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }
}

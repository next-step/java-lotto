package step2;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoTier {
    FIRST(6, 2_000_000_000, matchingCount -> matchingCount == 6),
    SECOND(5, 1_500_000, matchingCount -> matchingCount == 5),
    THIRD(4, 50_000, matchingCount -> matchingCount == 4),
    FOURTH(3,5_000, matchingCount -> matchingCount == 3),
    NONE(0,0, matchingCount -> matchingCount < 3);

    private final int matchingCount;
    private final int prize;
    private final Function<Integer, Boolean> isWinning;

    LottoTier(int matchingCount, int prize, Function<Integer, Boolean> isWinning) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.isWinning = isWinning;
    }

    public boolean from(int matchingCount) {
        return isWinning.apply(matchingCount);
    }

    public static LottoTier getTier(int matchingCount) {
        return Arrays.stream(values())
                .filter(tier -> tier.from(matchingCount))
                .findFirst()
                .orElse(NONE);
    }

    public Integer calculatePrize(Integer count) {
        return count * prize;
    }
}

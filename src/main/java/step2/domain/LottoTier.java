package step2.domain;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum LottoTier {
    FIRST(6, 2_000_000_000, (matchingCount, isMatchBonus) -> matchingCount == 6),
    SECOND(5, 30_000_000, (matchingCount, isMatchBonus) -> matchingCount == 5 && isMatchBonus),
    THIRD(5, 1_500_000, (matchingCount, isMatchBonus) -> matchingCount == 5 && !isMatchBonus),
    FOURTH(4,50_000, (matchingCount, isMatchBonus) -> matchingCount == 4),
    FIFTH(3,5_000, (matchingCount, isMatchBonus) -> matchingCount == 3),
    NONE(0,0, (matchingCount, isMatchBonus) -> matchingCount < 3);

    private final long matchingCount;
    private final int prize;
    private final BiFunction<Long, Boolean, Boolean> isWinning;

    LottoTier(long matchingCount, int prize, BiFunction<Long, Boolean, Boolean> isWinning) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.isWinning = isWinning;
    }

    public boolean from(long matchingCount, boolean isMatchBonus) {
        return isWinning.apply(matchingCount, isMatchBonus);
    }

    public static LottoTier getTier(long matchingCount, boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(tier -> tier.from(matchingCount, isMatchBonus))
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

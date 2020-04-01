package step2.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoTier {

    FIRST(6, 2_000_000_000, (matchedNumberCount, isMatchBonusNumber) -> matchedNumberCount == 6),
    SECOND(5, 30_000_000, (matchedNumberCount, isMatchBonusNumber) -> matchedNumberCount == 5 && isMatchBonusNumber),
    THIRD(5, 150_000, (matchedNumberCount, isMatchBonusNumber) -> matchedNumberCount == 5 && !isMatchBonusNumber),
    FOURTH(4, 50_000, (matchedNumberCount, isMatchBonusNumber) -> matchedNumberCount == 4),
    FIFTH(3,5_000, (matchedNumberCount, isMatchBonusNumber) -> matchedNumberCount == 3),
    NONE(0,0, (matchedNumberCount, isMatchBonusNumber) -> matchedNumberCount < 3);

    private long matchedNumberCount;
    private int prize;
    private final BiFunction<Long, Boolean, Boolean> isWinning;

    public boolean of(long matchedNumberCount, boolean isMatchBonusNumber) {
        return isWinning.apply(matchedNumberCount, isMatchBonusNumber);
    }

    LottoTier(long matchedNumberCount, int prize, BiFunction<Long, Boolean, Boolean> isWinning) {
        this.matchedNumberCount = matchedNumberCount;
        this.prize = prize;
        this.isWinning = isWinning;
    }
    public int calculatePrize(int count) {
        return count * prize;
    }

    public static LottoTier getTier(long matchedNumberCount, boolean isMatchBonusNumber) {
        return Arrays.stream(values())
                .filter(tier -> tier.of(matchedNumberCount, isMatchBonusNumber))
                .findFirst()
                .orElse(NONE);
    }

    public long getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getPrize() {
        return prize;
    }
}

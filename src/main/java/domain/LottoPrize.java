package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoPrize {
    FIRST(6, 2_000_000_000L, (matchCount, matchBonus) -> matchCount == 6),
    SECOND(5, 30_000_000L, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    THIRD(5, 1_500_000L, (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    FOURTH(4, 50_000L, (matchCount, matchBonus) -> matchCount == 4),
    FIFTH(3, 5_000L, (matchCount, matchBonus) -> matchCount == 3),
    NO_MATCH(0, 0, (matchCount, matchBonus) -> matchCount >= 0 && matchCount < 3);

    private final int matchCount;
    private final long winningPrize;
    private final BiFunction<Integer, Boolean, Boolean> isMatched;

    LottoPrize(int matchCount, long winningPrize, BiFunction<Integer, Boolean, Boolean> isMatched) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
        this.isMatched = isMatched;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long winningPrize() {
        return winningPrize;
    }

    private boolean isMatched(int num, boolean bonus) {
        return isMatched.apply(num, bonus);
    }

    public static LottoPrize fromMatchCount(int num, boolean matchBonus) {
        validateMatchCount(num);
        return Arrays.stream(values())
                .filter(LottoPrize -> LottoPrize.isMatched(num, matchBonus))
                .findFirst().orElse(NO_MATCH);
    }

    private static void validateMatchCount(int num) {
        if (num > FIRST.matchCount) {
            throw new IllegalArgumentException("로또 최대 매칭 가능한 갯수는 " + FIRST.matchCount + "입니다.");
        }
    }
}


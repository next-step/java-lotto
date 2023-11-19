package domain;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoPrize {
    FIRST(6, 2_000_000_000L, (matchCount) -> matchCount == 6),
    SECOND(5, 1_500_000L, (matchCount) -> matchCount == 5),
    THIRD(4, 50_000L, (matchCount) -> matchCount == 4),
    FOURTH(3, 5_000L, (matchCount) -> matchCount == 3),
    NO_MATCH(0, 0, (matchCount) -> matchCount >= 0 && matchCount < 3),
    ;

    private final int matchCount;
    private final long winningPrize;
    private final Function<Integer, Boolean> isMatched;

    LottoPrize(int matchCount, long winningPrize, Function<Integer, Boolean> isMatched) {
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

    public static LottoPrize fromMatchCount(int num) {
        if (num > FIRST.matchCount) {
            throw new IllegalArgumentException("로또 최대 매칭 가능한 갯수는 " + FIRST.matchCount + "입니다.");
        }
        return Arrays.stream(values())
                .filter(type -> type.isMatched(num))
                .findFirst().orElse(NO_MATCH);
    }

    private boolean isMatched(int num) {
        return isMatched.apply(num);
    }
}


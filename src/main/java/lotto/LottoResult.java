package lotto;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoResult {
    NONE(0, (matchingCount, bonus) -> matchingCount >= 0 && matchingCount < 3, 0),
    FIFTH(3, (matchingCount, bonus) -> matchingCount == 3, 5000),
    FOURTH(4, (matchingCount, bonus) -> matchingCount == 4, 50000),
    THIRD(5, (matchingCount, bonus) -> matchingCount == 5 && !bonus, 1500000),
    SECOND(5, (matchingCount, bonus) -> matchingCount == 5 && bonus, 30000000),
    FIRST(6, (matchingCount, bonus) -> matchingCount == 6, 2000000000);

    private final int matchingCount;
    private final BiFunction<Integer, Boolean, Boolean> matchRule;
    private final int prize;

    LottoResult(int matchingCount, BiFunction<Integer, Boolean, Boolean> matchRule, int prize) {
        this.matchingCount = matchingCount;
        this.matchRule = matchRule;
        this.prize = prize;
    }

    public static LottoResult of(int matchingCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(result -> result.matchRule.apply(matchingCount, bonus))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonus() {
        return this == SECOND;
    }

    public int getPrize() {
        return prize;
    }
}

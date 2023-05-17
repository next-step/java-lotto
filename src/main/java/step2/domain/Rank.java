package step2.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    MISS(0, 0, "0개 일치 (0)", (matchCount, hasBonus) -> matchCount < 3),
    FIFTH(3, 5_000, "3개 일치 (5000)", (matchCount, hasBonus) -> matchCount == 3),
    FOURTH(4, 50_000, "4개 일치 (50000)", (matchCount, hasBonus) -> matchCount == 4),
    THIRD(5, 1_500_000, "5개 일치 (1500000)", (matchCount, hasBonus) -> matchCount == 5 && !hasBonus),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)", (matchCount, hasBonus) -> matchCount == 5 && hasBonus),
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000)", (matchCount, hasBonus) -> matchCount == 6);

    private static final int THIRD_COUNT = 5;

    private int matchCount;
    private long prizeMoney;
    private BiPredicate<Integer, Boolean> predicate;

    private String message;

    Rank(int matchCount, long rank, String message, BiPredicate<Integer, Boolean> predicate) {
        this.matchCount = matchCount;
        this.prizeMoney = rank;
        this.message = message;
        this.predicate = predicate;
    }

    public static Rank toPrizeMoney(int matchCount, boolean hasBonus) {

        return Arrays.stream(values())
                .filter(prizeMoney -> prizeMoney.predicate.test(matchCount, hasBonus))
                .findAny()
                .orElse(Rank.MISS);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public long prizeMoney() {
        return this.prizeMoney;
    }

    public String message() {
        return this.message;
    }

    private boolean isSameMathCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}

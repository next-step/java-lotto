package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2_000_000_000L, 6),
    SECOND(30_000_000L, 5) {
        @Override
        boolean match(int matchCount, boolean bonusMatch) {
            return this.matchCount == matchCount && bonusMatch;
        }
    },
    THIRD(1_500_000L, 5) {
        @Override
        boolean match(int matchCount, boolean bonusMatch) {
            return this.matchCount == matchCount && !bonusMatch;
        }
    },
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3),
    NONE(0L) {
        @Override
        boolean match(int matchCount, boolean bonusMatch) {
            return matchCount < 3;
        }
    };

    private final long price;
    protected final int matchCount;

    LottoRank(long price) {
        this(price, 0);
    }

    LottoRank(long price, int matchCount) {
        this.price = price;
        this.matchCount = matchCount;
    }

    public long getPrice() {
        return price;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public static LottoRank rank(int matchCount, boolean bonusMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(it -> it.match(matchCount, bonusMatch))
                .findAny()
                .orElse(LottoRank.NONE);
    }

    boolean match(int matchCount, boolean bonusMatch) {
        return this.matchCount == matchCount;
    }
}

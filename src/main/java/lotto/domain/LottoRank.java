package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    MISS(0, 0L);

    private final int matchingCount;
    private final long prize;

    LottoRank(int matchingCount, long prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrize() {
        return prize;
    }

    public static LottoRank findByMatchingCount(int matchingCount) {
        return Arrays.stream(values())
                .filter(r -> r.matchingCount == matchingCount)
                .findFirst()
                .orElse(MISS);
    }

    public static LottoRank valueOf(int matchingCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(r -> r.matchingCount == matchingCount)
                .filter(r -> !r.equals(SECOND) || matchBonus)
                .findFirst()
                .orElse(MISS);
    }

}

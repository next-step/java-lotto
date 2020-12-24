package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    MISS(0, 0L, ""),
    FIFTH(3, 5_000L, ""),
    FOURTH(4, 50_000L, ""),
    THIRD(5, 1_500_000L, ""),
    SECOND(5, 30_000_000L, ", 보너스 볼 일치"),
    FIRST(6, 2_000_000_000L, "");

    private final int matchingCount;
    private final long prize;
    private final String comment;

    LottoRank(int matchingCount, long prize, String comment) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.comment = comment;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrize() {
        return prize;
    }

    public String getComment() {
        return comment;
    }

    /*
    public static LottoRank findByMatchingCount(int matchingCount) {
        return Arrays.stream(values())
                .filter(r -> r.matchingCount == matchingCount)
                .findFirst()
                .orElse(MISS);
    }
    */

    public static LottoRank valueOf(int matchingCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(r -> r.matchingCount == matchingCount)
                .filter(r -> !r.equals(THIRD) || !matchBonus)
                .findFirst()
                .orElse(MISS);
    }

}

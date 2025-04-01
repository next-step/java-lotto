package lotto;

import java.util.Arrays;

public enum LottoRank {
    RANK_1(6, 2000000000),
    RANK_3(5, 1500000),
    RANK_4(4, 50000),
    RANK_5(3, 5000),
    UNRANKED(0, 0);

    private final long matchCount;
    private final int prize;

    LottoRank(long matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank valueOf(long matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(UNRANKED);
    }

    public int getPrize() {
        return prize;
    }
}

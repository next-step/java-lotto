package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(null,0);

    private Integer matchCount;
    private long prize;

    LottoRank(Integer matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public static LottoRank getRank(int count) {
        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.matchCount == count)
            .findFirst()
            .orElse(NONE);
    }
}

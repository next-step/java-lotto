package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NOT_MATCH(0, 0);

    private int matchCount;
    private int winning;

    LottoRank(int matchCount, int winning) {
        this.matchCount = matchCount;
        this.winning = winning;
    }

    public static LottoRank find(long matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findFirst()
                .orElse(NOT_MATCH);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinning() {
        return winning;
    }
}

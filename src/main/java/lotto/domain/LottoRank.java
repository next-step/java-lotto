package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 1_500_000),
    THIRD("3등", 4, 50_000),
    FOURTH("4등", 3, 5_000),
    NONE("낙첨", 0, 0);

    private final String rank;
    private final int matchCount;
    private final int prizeMoney;

    LottoRank(String rank, int matchCount, int prizeMoney) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getRank() {
        return rank;
    }

    public static LottoRank valueOfMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoRnak -> lottoRnak.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }
}

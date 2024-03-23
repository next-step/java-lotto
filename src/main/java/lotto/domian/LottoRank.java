package lotto.domian;

import java.util.Arrays;

public enum LottoRank {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 1_500_000),
    THIRD("3등", 4, 50_000),
    FOURTH("4등", 3, 5_000),
    NONE("꽝",0, 0);

    private final String rank;
    private final int matchCount;
    private final int prizeMoney;

    LottoRank(String rank, int matchCount, int prizeMoney) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank valueOfMatchCount(int matchCount){
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return this.matchCount;
    }
    public int getPrizeMoney() { return this.prizeMoney;}
    public String getRank() {
        return rank;
    }

}

package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 1_500_000),
    THIRD("3등", 4, 50_000),
    FOURTH("4등", 3, 5_000),
    NO_RANK("미당첨", 0, 0);


    private String rankName;
    private int matchedCount;
    private int prizeMoney;

    LottoRank(String rankName, int matchingCount, int prizeMoney) {
        this.rankName = rankName;
        this.matchedCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findByMatchedCount(int count) {
        return Arrays.stream(LottoRank.values())
                .filter(lotteRank -> lotteRank.matchedCount == count)
                .findAny()
                .orElse(LottoRank.NO_RANK);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}


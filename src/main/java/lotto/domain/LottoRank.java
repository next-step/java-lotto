package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST("6개 일치", 6, 2_000_000_000),
    SECOND("5개 일치", 5, 1_500_000),
    THIRD("4개 일치", 4, 50_000),
    FOURTH("3개 일치", 3, 5_000),
    NO_RANK("미당첨", 0, 0);

    private String description;
    private int matchedCount;
    private int prizeMoney;

    LottoRank(String description, int matchingCount, int prizeMoney) {
        this.description = description;
        this.matchedCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findByMatchedCount(int count) {
        return Arrays.stream(LottoRank.values())
                .filter(lotteRank -> lotteRank.matchedCount == count)
                .findAny()
                .orElse(LottoRank.NO_RANK);
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}


package step2.constant;

import java.util.Arrays;

public enum Prize {
    FOURTH(3, 5_000, "3개 일치 (5000원)"),
    THIRD(4, 50_000, "4개 일치 (50000원)-"),
    SECOND(5, 1_500_000, "5개 일치 (1500000원)-"),
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000원)-");

    private int matchCount;
    private int prizeMoney;
    private String result;

    Prize(int matchCount, int prizeMoney, String result) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.result = result;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getResult() {
        return result;
    }

}

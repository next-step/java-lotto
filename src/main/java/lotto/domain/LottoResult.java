package lotto.domain;

public enum LottoResult {
    MATCH_6("1", 6, 2000000000),
    MATCH_5("2", 5, 150000),
    MATCH_4("3", 4, 50000),
    MATCH_3("4", 3, 5000),
    MATCH_2("0", 2, 0),
    MATCH_1("0", 1, 0),
    MATCH_0("0", 0, 0);

    private final String grade;
    private final int matchCount;
    private final int profit;

    LottoResult(String grade, int matchCount, int profit) {
        this.grade = grade;
        this.matchCount = matchCount;
        this.profit = profit;
    }

    public int matchCount() {
        return matchCount;
    }

    public int profit() {
        return profit;
    }
}

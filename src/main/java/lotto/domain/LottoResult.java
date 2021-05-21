package lotto.domain;

public enum LottoResult {
    MATCH_6("1", 6),
    MATCH_5("2", 5),
    MATCH_4("3", 4),
    MATCH_3("4", 3),
    MATCH_2("5", 2),
    MATCH_1("0", 1),
    MATCH_0("0", 0);

    private final String grade;
    private final int matchCount;

    LottoResult(String grade, int matchCount) {
        this.grade = grade;
        this.matchCount = matchCount;
    }

    public String grade() {
        return grade;
    }

    public int matchCount() {
        return matchCount;
    }
}

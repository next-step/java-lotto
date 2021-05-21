package lotto.domain;

public enum LottoResult {
    MATCH_(-1, -1),
    MATCH_6(1, 6),
    MATCH_5(2, 5),
    MATCH_4(3, 4),
    MATCH_3(4, 3),
    MATCH_2(5, 2),
    MATCH_1(-1, 1),
    MATCH_0(-1, 0);

    private final int grade;
    private final int matchCount;

    LottoResult(int grade, int matchCount) {
        this.grade = grade;
        this.matchCount = matchCount;
    }

    public int matchCount() {
        return matchCount;
    }
}

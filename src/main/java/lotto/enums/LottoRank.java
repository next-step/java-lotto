package lotto.enums;

public enum LottoRank {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3);

    private int matchCount;

    LottoRank(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}

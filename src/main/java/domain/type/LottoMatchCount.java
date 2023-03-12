package domain.type;

public enum LottoMatchCount {
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    ETC(0);

    private int matchCount;

    private LottoMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}

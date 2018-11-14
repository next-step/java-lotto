package enums;

public enum  LottoReword {
    MISS_MATCH(0, 0),
    ONE_MATCH(1, 0),
    TWO_MATCH(2, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private int matchCount;
    private int reword;

    LottoReword(int matchCount, int reword) {
        this.matchCount = matchCount;
        this.reword = reword;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReword() {
        return reword;
    }


}

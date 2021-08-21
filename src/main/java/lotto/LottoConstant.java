package lotto;

public enum LottoConstant {
    FOURTH(3, 5_000, 3),
    THIRD(4, 50_000, 2),
    SECOND(5, 1_500_000, 1),
    FIRST(6, 2_000_000_000, 0);

    private int matchedCount;
    private int prizeMoney;
    private int placeIndex;

    private LottoConstant(int matchedCount, int prizeMoney, int placeIndex) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
        this.placeIndex = placeIndex;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }

    public int getPlaceIndex() {
        return this.placeIndex;
    }
}

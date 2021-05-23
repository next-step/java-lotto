package step3.constant;

public enum WinnerPrice {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    DEFAULT(0, 0);

    private Integer matchedCount;
    private Integer winnerPrice;

    private WinnerPrice(Integer matchedCount, Integer winnerPrice) {
        this.matchedCount = matchedCount;
        this.winnerPrice = winnerPrice;
    }

    public Integer matchedCount() {
        return matchedCount;
    }

    public Integer winnerPrice() {
        return winnerPrice;
    }

}

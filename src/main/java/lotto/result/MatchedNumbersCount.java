package lotto.result;

public enum MatchedNumbersCount {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchedNumbersCount;
    private final int price;

    MatchedNumbersCount(int matchedNumbersCount, int price) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.price = price;
    }

    public int value() {
        return matchedNumbersCount;
    }

    public boolean isEqualsTo(long count) {
        return matchedNumbersCount == count;
    }

    public int price() {
        return price;
    }

    public long prize(Long quantity) {
        return price * quantity;
    }
}

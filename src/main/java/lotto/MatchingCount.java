package lotto;

public enum MatchingCount {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int count;
    private final int price;

    MatchingCount(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int value() {
        return count;
    }

    public long prize(Long quantity) {
        return price * quantity;
    }
}

package lotto;

public enum MatchedNumbers {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int count;
    private final int price;

    MatchedNumbers(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int count() {
        return count;
    }

    public long prize(Long quantity) {
        return price * quantity;
    }
}

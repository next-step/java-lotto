package lotto;

public enum MatchedNumbers {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchedNumber;
    private final int price;

    MatchedNumbers(int matchedNumber, int price) {
        this.matchedNumber = matchedNumber;
        this.price = price;
    }

    public int value() {
        return matchedNumber;
    }

    public int price() {
        return price;
    }

    public long prize(Long quantity) {
        return price * quantity;
    }
}

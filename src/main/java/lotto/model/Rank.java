package lotto.model;


public enum Rank {
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(2_000_000_000);

    private final int price;

    Rank(int price) {
        this.price = price;
    }

    public int getAllMatchPrice(int matchingNumbers) {
        return this.price * matchingNumbers;
    }
}

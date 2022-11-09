package lotto.model;


public enum Rank {
    THREE(3, 5_000),
    FOUR(4,50_000),
    FIVE(5,1_500_000),
    SIX(6,2_000_000_000);

    private final int order;
    private final int price;

    Rank(int order, int price) {
        this.order = order;
        this.price = price;
    }

    public int calculatePrice(int matchingNumbers) {
        return this.price * matchingNumbers;
    }

    public boolean event(int input) {
        return input == this.order;
    }
}

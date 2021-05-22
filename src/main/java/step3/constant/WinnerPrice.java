package step3.constant;

public enum WinnerPrice {
    TREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000);

    private int price;

    private WinnerPrice(int price) {
        this.price = price;
    }

    public int price() {
        return price;
    }

}

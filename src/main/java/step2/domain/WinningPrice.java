package step1.domain;

public enum WinningPrice {

    FIRST_PRIZE(2000000000,6),
    SECOND_PRIZE(1500000,5),
    THIRD_PRIZE(50000,4),
    FOURTH_PRIZE(5000,3);


    private final int price;
    private final int count;

    WinningPrice(int price, int count)  {
        this.price = price;
        this.count = count;
    }

    public int winningPrice() {
        return price;
    }

}

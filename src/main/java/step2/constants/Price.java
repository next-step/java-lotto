package step2.constants;

public enum Price {

    LOTTO(1000),
    MISS(0),
    FIFTH(5000),
    FORTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);

    private int price;

    Price(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

package lotto.model;

public enum WinningPrice {
    FIFTHPRICE(5_000),
    FOURTHPRICE(50_000),
    THIRDPRICE(1_500_000),
    SECONDPRICE(30_000_000),
    FIRSTPRICE(2_000_000_000);

    private int price;

    WinningPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

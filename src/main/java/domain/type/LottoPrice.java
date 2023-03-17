package domain.type;

public enum LottoPrice {
    PRICE(1000);

    private int price;

    private LottoPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

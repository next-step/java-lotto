package lotto.enumeration;

public enum LottoPrices {
    TICKET_PRICE(1000);

    private int price;

    LottoPrices(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

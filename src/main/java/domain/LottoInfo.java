package domain;

public class LottoInfo {
    private int price;
    private int quantity;

    private LottoInfo(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    private LottoInfo(int price) {
        this.price = price;
    }

    public static LottoInfo of(int price, int quantity) {
        return new LottoInfo(price, quantity);
    }

    public static LottoInfo from(int price) {
        return new LottoInfo(price);
    }

    public int getPrice() {
        return price;
    }

}

package lottoGame.model.price;

public class BuyPrice {
    private final int price;

    public BuyPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("로또가격은 0보다 커야 합니다.");
        }

        this.price = price;
    }

    public int calculateLottoCount(int perLottoPrice) {
        if (perLottoPrice < 0) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }

        return price / perLottoPrice;
    }
}

package step2;

public class LottoPrice {

    private static int LOTTO_PRICE_PER_UNIT = 1000;
    private int price;

    public LottoPrice(String inputPrice) {
        int price = Integer.parseInt(inputPrice);
        if ( price < LOTTO_PRICE_PER_UNIT) {
            throw new IllegalArgumentException(String.format("로또 구매 최소 금액은 %d 입니다.", LOTTO_PRICE_PER_UNIT));
        }
        this.price = price;
    }

    public int getAvailableForPurchaseCount() {
        return price / LOTTO_PRICE_PER_UNIT;
    }
}

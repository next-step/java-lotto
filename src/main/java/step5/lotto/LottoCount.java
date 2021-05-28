package step5.lotto;

public class LottoCount {
    private static final int DEFAULT_PRICE = 1000;
    private static final String DEFAULT_PRICE_EXCEPTION = "로또는 1000원 이상부터 구매할수있습니다.";

    private int lottoCount;

    public LottoCount(int price) {
        if (price < DEFAULT_PRICE) {
            throw new RuntimeException(DEFAULT_PRICE_EXCEPTION);
        }
        this.lottoCount = calculatePriceToCount(price);
    }

    public int calculatePriceToCount(int price) {
        return price / DEFAULT_PRICE;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public int calculateCountToPrice() {
        return this.lottoCount * DEFAULT_PRICE;
    }
}

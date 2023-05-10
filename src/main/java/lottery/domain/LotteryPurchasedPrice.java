package lottery.domain;

public class LotteryPurchasedPrice {

    protected static final int LOTTERY_PRICE = 1000;

    private static final String INVALID_PRICE_MSG = String.format("로또 최소 구매 금액은 %d원 이상입니다.",
            LOTTERY_PRICE);

    private final int value;

    public LotteryPurchasedPrice(int value) {
        if (invalidPrice(value)) {
            throw new IllegalArgumentException(INVALID_PRICE_MSG);
        }
        this.value = value;
    }

    private boolean invalidPrice(int purchasePrice) {
        return purchasePrice < LOTTERY_PRICE;
    }

    public int numberOfPlays() {
        return this.value / LOTTERY_PRICE;
    }
}

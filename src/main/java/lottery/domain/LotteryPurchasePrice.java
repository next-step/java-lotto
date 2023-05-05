package lottery.domain;

public class LotteryPurchasePrice {

    protected static final int LOTTERY_PRICE = 1000;

    private static final String INVALID_PRICE_MSG = String.format("로또 최소 구매 금액은 %d원 이상입니다.",
            LOTTERY_PRICE);

    private final int purchasedPrice;

    public LotteryPurchasePrice(int purchasedPrice) {
        if (invalidPrice(purchasedPrice)) {
            throw new IllegalArgumentException(INVALID_PRICE_MSG);
        }
        this.purchasedPrice = purchasedPrice;
    }

    private boolean invalidPrice(int purchasePrice) {
        return purchasePrice < LOTTERY_PRICE;
    }

    public int numberOfPlays() {
        return this.purchasedPrice / LOTTERY_PRICE;
    }


}

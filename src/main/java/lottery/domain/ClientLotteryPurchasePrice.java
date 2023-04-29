package lottery.domain;

public class ClientLotteryPurchasePrice {

    private static final int LOTTERY_PRICE = 1000;

    private static final String INVALID_PRICE_MSG = "로또 최소 구매 금액은 1000원 이상입니다.";

    private final int purchasePrice;

    public ClientLotteryPurchasePrice(int purchasePrice) {
        if(invalidPrice(purchasePrice)) {
            throw new IllegalArgumentException(INVALID_PRICE_MSG);
        }
        this.purchasePrice = purchasePrice;
    }

    private boolean invalidPrice(int purchasePrice) {
        return purchasePrice < LOTTERY_PRICE;
    }

    public int getLotteries() {
        return this.purchasePrice / LOTTERY_PRICE;
    }
}

package lottery.domain;

import static lottery.domain.constant.LotteryNumberRule.LOTTERY_PRICE;

public class LotteryPurchasePrice {

    private static final String INVALID_PRICE_MSG = String.format("로또 최소 구매 금액은 %d원 이상입니다.",
            LOTTERY_PRICE.getRuleNumber());

    private final int purchasedPrice;

    public LotteryPurchasePrice(int purchasedPrice) {
        if (invalidPrice(purchasedPrice)) {
            throw new IllegalArgumentException(INVALID_PRICE_MSG);
        }
        this.purchasedPrice = purchasedPrice;
    }

    private boolean invalidPrice(int purchasePrice) {
        return purchasePrice < LOTTERY_PRICE.getRuleNumber();
    }

    public int getLotteries() {
        return this.purchasedPrice / LOTTERY_PRICE.getRuleNumber();
    }


}

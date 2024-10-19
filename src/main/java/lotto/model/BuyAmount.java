package lotto.model;

import static lotto.model.Result.LOTTO_PRICE;

public class BuyAmount {

    public static final String ERROR_LOWER_MINIMUM_BUY_AMOUNT = "최소 구매금액보다 작습니다.";
    public static final String LOTTO_NOT_ALLOWED_REMAINDER = "로또는 천원단위로 구매가 가능합니다.";
    private final int amount;

    public BuyAmount(int amount) {
        boolean lowerMinimumBuyAmount = amount < LOTTO_PRICE;
        if (lowerMinimumBuyAmount) {
            throw new IllegalArgumentException(ERROR_LOWER_MINIMUM_BUY_AMOUNT);
        }

        boolean isNotBuyAmountRemainderZero = amount % LOTTO_PRICE != 0;
        if (isNotBuyAmountRemainderZero) {
            throw new IllegalArgumentException(LOTTO_NOT_ALLOWED_REMAINDER);
        }
        this.amount = amount;
    }

    public int count() {
        return amount / LOTTO_PRICE;
    }

}

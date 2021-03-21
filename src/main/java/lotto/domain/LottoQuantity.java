package lotto.domain;

public class LottoQuantity {
    private static final int LOTTO_AMOUNT = 1000;
    private static final String BUY_AMOUNT_ERROR = "천원 이상 구매해주시길 바랍니다.";

    private final int quantity;

    public LottoQuantity(int buyAmount) {
        this.quantity = amountToQuantity(buyAmount);
    }

    private void isBuyAmountValid(int buyAmount) {
        if (buyAmount < LOTTO_AMOUNT) {
            throw new IllegalArgumentException(BUY_AMOUNT_ERROR);
        }
    }

    private int amountToQuantity(int buyAmount) {
        isBuyAmountValid(buyAmount);
        return buyAmount / LOTTO_AMOUNT;
    }

    public int lottoQuantity() {
        return this.quantity;
    }
}

package lotto.domain;

public class LottoQuantity {
    private static final int LOTTO_AMOUNT = 1000;
    private static final String BUY_AMOUNT_ERROR = "천원 이상 구매해주시길 바랍니다.";
    private static final String MANUAL_QUANTITY_AMOUNT_ERROR = "구매 금액이 부족합니다.";
    private static final String MANUAL_MINUS_QUANTITY_ERROR = "0개 이상 입력해주세요";

    private final int buyAmount;
    private final int manualQuantity;

    public LottoQuantity(int buyAmount) {
        this(buyAmount, 0);
    }

    public LottoQuantity(int buyAmount, int manualQuatity) {
        isBuyAmountValid(buyAmount);
        isManualQuantityOverValid(buyAmount, manualQuatity);
        this.manualQuantity = manualQuatity;
        this.buyAmount = buyAmount;
    }

    private void isManualQuantityOverValid(int buyAmount, int manualQuatity) {
        int manualAmount = manualQuatity * LOTTO_AMOUNT;
        if (buyAmount < manualAmount) {
            throw new IllegalArgumentException(MANUAL_QUANTITY_AMOUNT_ERROR);
        }

        if (manualQuatity < 0) {
            throw new IllegalArgumentException(MANUAL_MINUS_QUANTITY_ERROR);
        }
    }

    private void isBuyAmountValid(int buyAmount) {
        if (buyAmount < LOTTO_AMOUNT) {
            throw new IllegalArgumentException(BUY_AMOUNT_ERROR);
        }
    }

    public int amountToAutoQuantity() {
        return (buyAmount / LOTTO_AMOUNT) - manualQuantity;
    }

    public int uiManualQuantity() {
        return manualQuantity;
    }
}

package study.step4.domain;

public class LottoQuantity {
    private static final int LOTTO_AMOUNT = 1000;
    private static final String BUY_AMOUNT_ERROR = "천원 이상 구매해주시길 바랍니다.";
    private static final String MANUAL_QUANTITY_ERROR_MESSAGE = "구입금액을 확인해주세요.";

    private final int quantity;

    public LottoQuantity(int buyAmount, int manualLottoQuantity) {
        this.quantity = amountToQuantity(buyAmount, manualLottoQuantity) - manualLottoQuantity;
    }

    public LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int quantity() {
        return this.quantity;
    }

    private int amountToQuantity(int buyAmount, int manualLottoQuantity) {
        int result = buyAmount / LOTTO_AMOUNT;
        checkBuyAmountValid(buyAmount, manualLottoQuantity, result);
        return result;
    }

    private void checkBuyAmountValid(int buyAmount, int manualLottoQuantity, int result) {
        if (buyAmount < LOTTO_AMOUNT) {
            throw new IllegalArgumentException(BUY_AMOUNT_ERROR);
        }
        if (result < manualLottoQuantity) {
            throw new IllegalArgumentException(MANUAL_QUANTITY_ERROR_MESSAGE);
        }
    }
}

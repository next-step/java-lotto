package lotto.dto;

import lotto.domain.Lotto;
import lotto.exception.IllegalInputAmountException;

public class Amount {
    public static final String INVALID_AMOUNT_ERR_MSG = "구매 금액의 값은 0이하가 될 수 없습니다.";

    private int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount valueOf(int amount) {
        validateAmount(amount);
        return new Amount(amount);
    }

    private static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalInputAmountException(INVALID_AMOUNT_ERR_MSG);
        }
    }

    public boolean isInvalidNumberOfManualLottoSize(int numberOfManualLotto) {
        return (amount / Lotto.PRICE_OF_ONE_LOTTO) < numberOfManualLotto;
    }

    public void subtractOneLottoPrice() {
        amount -= Lotto.PRICE_OF_ONE_LOTTO;
    }

    public boolean isOverLottoPrice() {
        return amount >= Lotto.PRICE_OF_ONE_LOTTO;
    }
}

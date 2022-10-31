package lotto.domain;

import lotto.exception.InvalidInputException;

public class Amount {
    private static final String VALIDATE_MANUAL_AMOUNT = "수동으로 구매한 로또의 수량은 총 구입 수량을 넘을 수 없습니다.";

    private final Integer autoAmount;
    private final Integer manualAmount;

    public Amount(Integer totalAmount, Integer manualAmount) {
        validateAmount(totalAmount, manualAmount);
        this.autoAmount = totalAmount - manualAmount;
        this.manualAmount = manualAmount;
    }

    public Integer getAutoAmount() {
        return this.autoAmount;
    }

    public Integer getManualAmount() {
        return this.manualAmount;
    }

    private void validateAmount(Integer totalAmount, Integer manualAmount) {
        if (totalAmount < manualAmount) {
            throw new InvalidInputException(VALIDATE_MANUAL_AMOUNT);
        }
    }
}

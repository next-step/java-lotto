package lotto.domain;

import lotto.resources.ErrorMessages;

public class LottoCount {
    private static final int LOTTO_TICKET_PRICE = 1_000;

    private final int totalAmount;
    private final int autoLottoCount;
    private final int manualLottoCount;

    public LottoCount(Money money) {
        validate(money, 0);
        int totalCount = money.getAmount() / LOTTO_TICKET_PRICE;
        this.totalAmount = money.getAmount();
        this.autoLottoCount = totalCount;
        this.manualLottoCount = 0;
    }

    public LottoCount(Money money, int manualLottoCount) {
        validate(money, manualLottoCount);
        int totalCount = money.getAmount() / LOTTO_TICKET_PRICE;
        this.totalAmount = money.getAmount();
        this.autoLottoCount = totalCount - manualLottoCount;
        this.manualLottoCount = manualLottoCount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    private void validate(Money money, int manualLottoCount) {
        int manualLottoAmount = manualLottoCount * LOTTO_TICKET_PRICE;
        if (money.getAmount() < manualLottoAmount) {
            throw new IllegalArgumentException(ErrorMessages.MANUAL_AMOUNT_SUM_BOUNDARY_ERROR_MESSAGE);
        }
    }
}

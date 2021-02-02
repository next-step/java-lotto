package lotto.domain;

import lotto.resources.ErrorMessages;

public class LottoCount {
    private static final int LOTTO_TICKET_PRICE = 1_000;

    private final int totalCount;
    private final int autoLottoCount;
    private final int manualLottoCount;

    public LottoCount(Money money, int manualLottoCount) {
        validate(money, manualLottoCount);
        this.totalCount = money.getAmount() / LOTTO_TICKET_PRICE;
        this.autoLottoCount = totalCount - manualLottoCount;
        this.manualLottoCount = manualLottoCount;
    }

    public int getTotalCount() {
        return totalCount;
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

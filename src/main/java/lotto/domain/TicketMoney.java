package lotto.domain;

import lotto.exception.MinimumPurchaseAmountException;

public class TicketMoney {
    private static final int TICKET_PRICE = 1000;
    private static final int MINIMUM_COUNTS = 0;
    private static final String MANUAL_PURCHASE_MESSAGE = "총 금액 이하로 수동 로또를 구매할 수 있습니다.";

    private final int totalLottoTicketCount;
    private int manualCount;


    public TicketMoney(int purchaseMoney) {
        negativeNumberValidator(purchaseMoney);
        this.totalLottoTicketCount = totalLottoTicketCount(purchaseMoney);
    }

    public void manualPurchase(int manualCount) {
        negativeNumberValidator(manualCount);
        manualCountValidator(manualCount);
        this.manualCount = manualCount;
    }
    private void manualCountValidator(int manualCount) {
        if (totalLottoTicketCount < manualCount) {
            throw new RuntimeException(MANUAL_PURCHASE_MESSAGE);
        }
    }

    private int totalLottoTicketCount(int purchaseMoney) {
        return purchaseMoney / TICKET_PRICE;
    }

    private void negativeNumberValidator(int purchaseMoney) {
        if (purchaseMoney < MINIMUM_COUNTS) {
            throw new MinimumPurchaseAmountException();
        }
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return totalLottoTicketCount - manualCount;
    }
}

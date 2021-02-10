package lotto.domain;

import lotto.Constant;

public class LottoCount {

    private final int totalCounts;
    private final int manualCounts;

    public LottoCount(Money money) {
        this.totalCounts = money.calculateTickets();
        this.manualCounts = 0;
    }

    public LottoCount(Money money, int manualCount) {
        validate(money, manualCount);
        this.totalCounts = money.calculateTickets();
        this.manualCounts = manualCount;
    }

    public int calculateAutoCount() {
        return totalCounts - manualCounts;
    }

    private void validate(Money money, int manualCounts) throws IllegalArgumentException {
        int ticketCount = money.calculateTickets();
        if (manualCounts < 0 || manualCounts > ticketCount) {
            throw new IllegalArgumentException(Constant.ERROR_WINNING_NUMBER);
        }
    }
}

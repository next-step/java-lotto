package lotto.domain.winning;

import lotto.common.PositiveNumber;
import lotto.domain.ticket.LottoTicket;

public class EarningRate {
    private Double earningRate;

    private EarningRate(PositiveNumber totalWinningAmount, PositiveNumber totalPurchaseAmount) {
        this.earningRate = (double) totalWinningAmount.get() / totalPurchaseAmount.get();
    }

    public static EarningRate of(PositiveNumber totalWinningAmount, PositiveNumber purchaseTicketCount) {
        return new EarningRate(totalWinningAmount, PositiveNumber.of(purchaseTicketCount.get() * LottoTicket.PRICE));
    }

    public double get() {
        return earningRate;
    }
}

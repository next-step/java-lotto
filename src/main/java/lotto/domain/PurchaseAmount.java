package lotto.domain;

import java.util.List;

public class PurchaseAmount {

    private static final int LOTTO_TICKET_PRICE = 1_000;

    // TODO: 필드명 rename 고려
    private final int amount;
    private final int count;

    public PurchaseAmount(final int amount) {
        this.amount = amount;
        this.count = amount / LOTTO_TICKET_PRICE;
    }

    public PurchaseAmount(final List<LottoTicket> lottoTickets) {
        this.amount = lottoTickets.size() * LOTTO_TICKET_PRICE;
        this.count = lottoTickets.size();
    }

    public double calculateEarningsRateByTotalPrize(final long totalPrize) {
        return totalPrize / (double) this.amount;
    }

    public int getCount() {
        return count;
    }

    public PurchaseAmount minus(final int ticketsCount) {
        int deductedAmount = this.amount - (LOTTO_TICKET_PRICE * ticketsCount);
        return new PurchaseAmount(deductedAmount);
    }
}

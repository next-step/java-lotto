package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PurchaseAmount {

    private static final BigDecimal LOTTO_TICKET_PRICE = BigDecimal.valueOf(1_000L);

    private final BigDecimal totalAmount;
    private final int count;

    public PurchaseAmount(final BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        this.count = (totalAmount.divide(LOTTO_TICKET_PRICE, RoundingMode.DOWN)).intValue();
    }

    public PurchaseAmount(final List<LottoTicket> lottoTickets) {
        this.totalAmount = LOTTO_TICKET_PRICE.multiply(BigDecimal.valueOf(lottoTickets.size()));
        this.count = lottoTickets.size();
    }

    public double calculateEarningsRateByTotalPrize(final BigDecimal totalPrize) {
        return totalPrize.divide(this.totalAmount, 2, RoundingMode.DOWN).doubleValue();
    }

    // TODO: getter 삭제
    public int getCount() {
        return count;
    }

    public PurchaseAmount minus(final int ticketsCount) {
        BigDecimal deductedAmount = this.totalAmount.subtract(LOTTO_TICKET_PRICE.multiply(BigDecimal.valueOf(ticketsCount)));
        return new PurchaseAmount(deductedAmount);
    }
}

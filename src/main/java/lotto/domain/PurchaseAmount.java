package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static lotto.view.ExceptionMessages.AMOUNT_SMALLER_THAN_ZERO;
import static lotto.view.ExceptionMessages.AT_LEAST_ONE_LOTTO_TICKET;

public class PurchaseAmount {

    private static final BigDecimal LOTTO_TICKET_PRICE = BigDecimal.valueOf(1_000L);

    private final BigDecimal totalAmount;
    private final int count;

    public PurchaseAmount(final BigDecimal totalAmount) {
        validateAmount(totalAmount);
        this.totalAmount = totalAmount;
        this.count = totalAmount.divide(LOTTO_TICKET_PRICE, RoundingMode.DOWN).intValue();
    }

    public PurchaseAmount(final List<LottoTicket> lottoTickets) {
        validateCollectionSize(lottoTickets);
        this.totalAmount = LOTTO_TICKET_PRICE.multiply(BigDecimal.valueOf(lottoTickets.size()));
        this.count = lottoTickets.size();
    }

    private void validateAmount(final BigDecimal totalAmount) {
        if (isSmallerThanZero(totalAmount)) {
            throw new IllegalArgumentException(AMOUNT_SMALLER_THAN_ZERO);
        }
    }

    private boolean isSmallerThanZero(final BigDecimal totalAmount) {
        return totalAmount.compareTo(BigDecimal.ZERO) < 0;
    }

    private void validateCollectionSize(final List<LottoTicket> lottoTickets) {
        if (lottoTickets.isEmpty()) {
            throw new IllegalArgumentException(AT_LEAST_ONE_LOTTO_TICKET);
        }
    }

    public double calculateEarningsRateByTotalPrize(final BigDecimal totalPrize) {
        return totalPrize.divide(this.totalAmount, 2, RoundingMode.DOWN).doubleValue();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public int getCount() {
        return count;
    }

    public PurchaseAmount minusAmountBy(final int ticketsCount) {
        BigDecimal deductedAmount = this.totalAmount.subtract(LOTTO_TICKET_PRICE.multiply(BigDecimal.valueOf(ticketsCount)));
        return new PurchaseAmount(deductedAmount);
    }
}

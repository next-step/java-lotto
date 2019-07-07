package lotto.domain;

import lotto.common.PositiveNumber;
import lotto.domain.ticket.LottoTicket;

public class PurchaseAmount {
    private static final long MAX_PURCHASE_AMOUNT = 1_000_000L;
    private static final long MIN_PURCHASE_AMOUNT = 1_000L;

    private PositiveNumber manualTicketPurchaseCount;
    private PositiveNumber autoTicketPurchaseCount;

    private PurchaseAmount(PositiveNumber purchaseAmount, PositiveNumber manualTicketPurchaseCount) {
        validateRange(purchaseAmount);
        validateManualTicketCount(purchaseAmount, manualTicketPurchaseCount);

        this.manualTicketPurchaseCount = manualTicketPurchaseCount;
        this.autoTicketPurchaseCount = PositiveNumber.of(getNumberOfTickets(purchaseAmount) - manualTicketPurchaseCount.get());
    }

    public static PurchaseAmount of(PositiveNumber purchaseAmount) {
        return new PurchaseAmount(purchaseAmount, PositiveNumber.of(0));
    }

    public static PurchaseAmount ofManual(PositiveNumber purchaseAmount, PositiveNumber manualTicketPurchaseCount) {
        return new PurchaseAmount(purchaseAmount, manualTicketPurchaseCount);
    }

    private void validateRange(PositiveNumber purchaseAmount) {
        if ((purchaseAmount.get() < MIN_PURCHASE_AMOUNT || purchaseAmount.get() > MAX_PURCHASE_AMOUNT)) {
            throw new IllegalArgumentException("Invalid purchase amount");
        }
    }

    private void validateManualTicketCount(PositiveNumber purchaseAmount, PositiveNumber manualTicketPurchaseCount) {
        if (manualTicketPurchaseCount.get() > getNumberOfTickets(purchaseAmount)) {
            throw new IllegalArgumentException("Purchase amount is insufficient");
        }
    }

    public PositiveNumber getNumberOfTickets() {
        return PositiveNumber.of(getNumberOfManualTickets().get() + getNumberOfAutoTickets().get());
    }

    public PositiveNumber getNumberOfManualTickets() {
        return manualTicketPurchaseCount;
    }

    public PositiveNumber getNumberOfAutoTickets() {
        return autoTicketPurchaseCount;
    }

    private long getNumberOfTickets(PositiveNumber purchaseAmount) {
        return (purchaseAmount.get() / LottoTicket.PRICE);
    }
}

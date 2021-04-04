package lotto.domain;

import java.util.Objects;

public class TotalNumberOfTicket {
    private final PurchaseAmount purchaseAmount;
    private final LottoTicketPrice lottoTicketPrice;
    private final int numberOfTicket;

    public TotalNumberOfTicket(PurchaseAmount purchaseAmount, LottoTicketPrice lottoTicketPrice) {
        this.purchaseAmount = purchaseAmount;
        this.lottoTicketPrice = lottoTicketPrice;
        this.numberOfTicket = count();
    }

    protected int count() {
        return purchaseAmount.dividedBy(lottoTicketPrice);
    }

    public int numberOfTicket() {
        return numberOfTicket;
    }

    public int minus(ManualNumberOfTicket manualNumberOfTicket) {
        return numberOfTicket - manualNumberOfTicket.numberOfTicket();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalNumberOfTicket that = (TotalNumberOfTicket) o;
        return numberOfTicket == that.numberOfTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTicket);
    }
}

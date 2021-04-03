package lotto.domain;

import java.util.Objects;

public class NumberOfTicket {
    private final PurchaseAmount purchaseAmount;
    private final LottoTicketPrice lottoTicketPrice;
    private final int numberOfTicket;

    public NumberOfTicket(PurchaseAmount purchaseAmount, LottoTicketPrice lottoTicketPrice) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfTicket that = (NumberOfTicket) o;
        return numberOfTicket == that.numberOfTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTicket);
    }
}

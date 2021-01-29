package lotto.domain;

import lotto.dto.BuyerData;

import java.util.Objects;

public class LottoBuyer {
    private int ticketCnt = 0;

    public LottoBuyer(int ticketCnt) {
        this.ticketCnt = ticketCnt;
    }

    public boolean canBuyTicket() {
        return this.ticketCnt > 0;
    }

    public LottoTicket buyTicket() {
        ticketCnt--;
        return LottoTicketGenerator.generateRandomTicket();
    }

    public BuyerData getBuyerData() {
        return new BuyerData(ticketCnt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBuyer that = (LottoBuyer) o;
        return ticketCnt == that.ticketCnt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketCnt);
    }
}

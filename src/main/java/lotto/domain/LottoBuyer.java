package lotto.domain;

import lotto.dto.BuyerData;

import java.util.Objects;

public class LottoBuyer {
    private int autoTicketCnt;

    public LottoBuyer(int autoTicketCnt) {
        this.autoTicketCnt = autoTicketCnt;
    }

    public boolean canBuyAutoTicket() {
        return this.autoTicketCnt > 0;
    }

    public LottoTicket buyAutoTicket() {
        autoTicketCnt--;
        return LottoTicketGenerator.generateRandomTicket();
    }

    public BuyerData getBuyerData() {
        return new BuyerData(autoTicketCnt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBuyer that = (LottoBuyer) o;
        return autoTicketCnt == that.autoTicketCnt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoTicketCnt);
    }
}

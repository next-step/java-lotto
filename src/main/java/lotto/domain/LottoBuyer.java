package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoBuyer {
    private int ticketCnt = 0;

    public LottoBuyer(int ticketCnt) {
        this.ticketCnt = ticketCnt;
    }

    public List<LottoTicket> BuyTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        while (ticketCnt-- > 0) {
            lottoTickets.add(
                LottoTicketGenerator.generateRandomTicket()
            );
        }
        return lottoTickets;
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

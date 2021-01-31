package lotto.domain;

import lotto.dto.BuyerData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuyer {
    private int autoTicketCnt;
    private List<LottoTicket> boughtAutoTickets;

    public LottoBuyer(int autoTicketCnt) {
        this.autoTicketCnt = autoTicketCnt;
        boughtAutoTickets = new ArrayList<>();
    }

    public boolean canBuyAutoTicket() {
        return this.autoTicketCnt - boughtAutoTickets.size() > 0;
    }

    public LottoTicket buyAutoTicket() {
        LottoTicket ticket = LottoTicketGenerator.generateRandomTicket();
        boughtAutoTickets.add(ticket);
        return ticket;
    }

    public void buyAutoTickets() {
        IntStream.range(
            0, autoTicketCnt
        ).forEach(
            i -> boughtAutoTickets.add(
                LottoTicketGenerator.generateRandomTicket()
            )
        );
    }

    public List<LottoTicket> getBoughtTickets() {
        return boughtAutoTickets;
    }

    public BuyerData getBuyerData() {
        return new BuyerData(
            autoTicketCnt,
            boughtAutoTickets.stream().map(
                ticket -> ticket.getTicketData()
            ).collect(
                Collectors.toList()
            )
        );
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

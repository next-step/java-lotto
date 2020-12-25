package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private final List<LottoTicket> ticketList;

    private LottoTickets(List<LottoTicket> ticketList) {
        this.ticketList = ticketList;
    }

    public static LottoTickets newTickets(List<LottoTicket> ticketList) {
        return new LottoTickets(ticketList);
    }

    public static LottoTickets newTickets(int purchaseCount) {
        List<LottoTicket> ticketList = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            ticketList.add(LottoTicket.newTicket());
        }

        return new LottoTickets(ticketList);
    }

    public LottoTicket getLottoTicket(int index) {
        return ticketList.get(index);
    }

    public int size() {
        return ticketList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(ticketList, that.ticketList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketList);
    }
}

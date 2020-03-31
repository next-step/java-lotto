package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> ticketList;

    public LottoTickets(int counts) {
        this.ticketList = new ArrayList<>();
        for (int i = 0; i < counts; i++) {
            ticketList.add(new LottoTicket());
        }
    }

    public List<LottoTicket> ticketList() {
        return ticketList;
    }
}

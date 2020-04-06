package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final int DEFAULT_TICKET_COUNT = 0;
    private final List<LottoTicket> ticketList = new ArrayList<>();

    public LottoTickets(int totalCount) {
        this(totalCount, new ArrayList<LottoTicket>(DEFAULT_TICKET_COUNT));
    }

    public LottoTickets(int autoTicketCount, List<LottoTicket> manualTickets) {
        for (LottoTicket manualTicket : manualTickets) {
            ticketList.add(manualTicket);
        }

        for (int i = DEFAULT_TICKET_COUNT; i < autoTicketCount; i++) {
            ticketList.add(new LottoTicket());
        }
    }

    public List<LottoTicket> ticketList() {
        return ticketList;
    }
}

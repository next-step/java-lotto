package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public LottoTicket createTicket(LottoTicketCreateStrategy createStrategy) {
        return LottoTicket.of(createStrategy);
    }

    public List<LottoTicket> createTickets(int ticketCount, LottoTicketCreateStrategy createStrategy) {
        List<LottoTicket> LottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            LottoTickets.add(createTicket(createStrategy));
        }
        return LottoTickets;
    }

}

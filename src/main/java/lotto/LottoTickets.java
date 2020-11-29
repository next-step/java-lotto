package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> ticketList = new ArrayList<>();

    private LottoTickets(int purchaseNumber, LottoTicketCreatable lottoTicketCreatable) {
        for (int i = 0; i < purchaseNumber; i++) {
            ticketList.add(lottoTicketCreatable.createTicket());
        }
    }

    public static LottoTickets newTickets(int purchaseNumber, LottoTicketCreatable lottoTicketCreatable) {
        return new LottoTickets(purchaseNumber, lottoTicketCreatable);
    }

    public LottoTicket getLottoTicket(int index) {
        return ticketList.get(index);
    }

    public int size() {
        return ticketList.size();
    }
}

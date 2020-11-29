package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> ticketList = new ArrayList<>();

    private LottoTickets(int purchaseNumber) {
        addTickets(purchaseNumber);
    }

    public static LottoTickets newTickets(int purchaseNumber) {
        return new LottoTickets(purchaseNumber);
    }

    private void addTickets(int purchaseNumber) {
        for (int i = 0; i < purchaseNumber; i++) {
            ticketList.add(new LottoTicket().newTicket(new LottoTicketCreation()));
        }
    }

    public LottoTicket getLottoTicket(int index) {
        return ticketList.get(index);
    }

    public int size() {
        return ticketList.size();
    }
}

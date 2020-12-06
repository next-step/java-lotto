package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketCreation implements LottoTicketCreatable {

    @Override
    public LottoTickets createTickets(int purchaseCount) {
        List<LottoTicket> ticketList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            ticketList.add(createTicket());
        }

        return LottoTickets.newTickets(ticketList);
    }

    @Override
    public LottoTicket createTicket() {
        List<Integer> ticket = createTicketNumber();
        Collections.sort(ticket);

        return LottoTicket.newTicket(ticket);
    }

    private List<Integer> createTicketNumber() {
        List<Integer> lottoTotalNumbers = LottoTotalNumberUtils.getLottoTotalNumbers();

        List<Integer> ticket = new ArrayList<>();
        for (int i = 0; i < LottoTicket.LOTTO_TICKET_SIZE; i++) {
            ticket.add(lottoTotalNumbers.get(i));
        }

        return ticket;
    }
}

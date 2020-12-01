package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketCreation implements LottoTicketCreatable {

    @Override
    public LottoTicket createTicket() {
        List<Integer> ticket = createTicketNumber();
        Collections.sort(ticket);

        return new LottoTicket(ticket);
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

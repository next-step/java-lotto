package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    public static final int LOTTO_TICKET_SIZE = 6;
    private final List<Integer> ticket;

    public LottoTicket() {
        this(new ArrayList<>());
    }

    public LottoTicket(List<Integer> ticket) {
        this.ticket = ticket;
    }

    public LottoTicket newTicket(LottoTicketCreatable lottoTicketCreatable) {
        return new LottoTicket(lottoTicketCreatable.createTicket());
    }

    public List<Integer> getTicket() {
        return Collections.unmodifiableList(ticket);
    }

    public int size() {
        return ticket.size();
    }
}

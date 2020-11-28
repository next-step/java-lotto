package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_TICKET_SIZE = 6;
    private final List<Integer> ticket;

    public LottoTicket() {
        this(new ArrayList<>());
    }

    public LottoTicket(List<Integer> ticket) {
        this.ticket = ticket;
    }

    public LottoTicket newTicket() {
        LottoTotalNumberUtils.shuffle();

        for (int i = 0; i < LOTTO_TICKET_SIZE; i++) {
            ticket.add(LottoTotalNumberUtils.getLottoTotalNumbers().get(i));
        }

        Collections.sort(ticket);

        return new LottoTicket(ticket);
    }

    public List<Integer> getTicket() {
        return Collections.unmodifiableList(ticket);
    }

    public int size() {
        return ticket.size();
    }
}

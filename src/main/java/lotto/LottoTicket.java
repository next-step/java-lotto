package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    public static final int LOTTO_TICKET_SIZE = 6;
    private final List<Number> ticket;

    private LottoTicket(List<Number> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket newTicket(List<Number> ticket) {
        validate(ticket);

        return new LottoTicket(ticket);
    }

    private static void validate(List<Number> ticket) {
        if (ticket.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_TICKET_SIZE + "개이어야 합니다.");
        }

        Set<Number> ticketSet = new HashSet<>(ticket);
        if (ticketSet.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Number> getTicket() {
        return Collections.unmodifiableList(ticket);
    }

    public int size() {
        return ticket.size();
    }
}

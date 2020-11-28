package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketCreation implements LottoTicketCreatable {

    @Override
    public List<Integer> createTicket() {
        List<Integer> ticket = addTicket();
        validateSize(ticket);
        Collections.sort(ticket);

        return ticket;
    }

    private void validateSize(List<Integer> ticket) {
        if (ticket.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개가 선택 되어야 합니다.");
        }
    }

    private List<Integer> addTicket() {
        List<Integer> ticket = new ArrayList<>();
        LottoTotalNumberUtils.shuffle();
        for (int i = 0; i < LottoTicket.LOTTO_TICKET_SIZE; i++) {
            ticket.add(LottoTotalNumberUtils.getLottoTotalNumbers().get(i));
        }

        return ticket;
    }
}

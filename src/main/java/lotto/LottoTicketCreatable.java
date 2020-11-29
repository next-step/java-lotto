package lotto;

import java.util.List;

@FunctionalInterface
public interface LottoTicketCreatable {

    List<Integer> createTicket();
}

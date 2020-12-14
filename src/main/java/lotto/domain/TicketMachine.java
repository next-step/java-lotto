package lotto.domain;

import java.util.List;

public interface TicketMachine {
    List<LottoTicket> issue(int ticketCount);
}

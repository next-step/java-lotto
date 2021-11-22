package lotto.domain;

import lotto.domain.value.LottoTicket;
import lotto.domain.value.TicketCount;

import java.util.List;

public interface GenerateLottoTicketStrategy {

    List<LottoTicket> publishTickets(TicketCount ticketCount);
}

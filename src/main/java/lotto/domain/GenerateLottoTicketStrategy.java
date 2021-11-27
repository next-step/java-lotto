package lotto.domain;

import lotto.domain.value.LottoTicket;
import lotto.domain.value.Price;

import java.util.List;

public interface GenerateLottoTicketStrategy {

    List<LottoTicket> publishTickets(Price ticketCount);
}

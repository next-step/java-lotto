package lotto.application;

import lotto.domain.LottoTicket;
import lotto.domain.Price;

import java.util.List;

public interface GenerateLottoTicketStrategy {

    List<LottoTicket> publishTickets(Price ticketCount);
}

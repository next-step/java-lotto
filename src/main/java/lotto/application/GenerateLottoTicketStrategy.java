package lotto.application;

import lotto.domain.LottoTickets;
import lotto.domain.Price;

public interface GenerateLottoTicketStrategy {

    LottoTickets publishTickets(Price ticketCount);
}

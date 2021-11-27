package lotto.domain;

import lotto.domain.value.LottoTicket;
import lotto.domain.value.LottoTickets;
import lotto.domain.value.Price;

import java.util.List;

public class LottoTicketGenerator {

    public LottoTicketGenerator() {
    }

    public LottoTickets generateTickets(Price ticketCount, GenerateLottoTicketStrategy lottoTicketStrategy) {
        List<LottoTicket> lottoTickets = lottoTicketStrategy.publishTickets(ticketCount);

        return LottoTickets.of(lottoTickets);
    }
}

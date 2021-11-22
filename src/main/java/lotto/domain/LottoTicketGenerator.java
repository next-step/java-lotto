package lotto.domain;

import addcalculator.exception.NotInstanceException;
import lotto.domain.value.LottoTicket;
import lotto.domain.value.LottoTickets;
import lotto.domain.value.TicketCount;

import java.util.List;

public class LottoTicketGenerator {

    public LottoTicketGenerator() {
    }

    public LottoTickets generateTickets(TicketCount ticketCount, GenerateLottoTicketStrategy lottoTicketStrategy) {
        List<LottoTicket> lottoTickets = lottoTicketStrategy.publishTickets(ticketCount);

        return LottoTickets.of(lottoTickets);
    }
}

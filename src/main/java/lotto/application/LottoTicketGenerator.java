package lotto.application;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Price;

import java.util.List;

public class LottoTicketGenerator {

    public LottoTicketGenerator() {
    }

    public LottoTickets generateTickets(Price price, GenerateLottoTicketStrategy lottoTicketStrategy) {
        List<LottoTicket> lottoTickets = lottoTicketStrategy.publishTickets(price);

        return LottoTickets.of(lottoTickets);
    }
}

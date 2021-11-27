package lotto.domain;

import lotto.domain.value.LottoTicket;
import lotto.domain.value.LottoTickets;
import lotto.domain.value.Price;

import java.util.List;

public class LottoTicketGenerator {

    public LottoTicketGenerator() {
    }

    public LottoTickets generateTickets(Price price, GenerateLottoTicketStrategy lottoTicketStrategy) {
        List<LottoTicket> lottoTickets = lottoTicketStrategy.publishTickets(price);

        return LottoTickets.of(lottoTickets);
    }
}

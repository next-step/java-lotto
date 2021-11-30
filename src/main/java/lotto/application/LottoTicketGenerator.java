package lotto.application;

import lotto.domain.LottoTickets;
import lotto.domain.Price;

public class LottoTicketGenerator {

    public LottoTickets generateTickets(Price price, GenerateLottoTicketStrategy lottoTicketStrategy) {
        return lottoTicketStrategy.publishTickets(price);
    }
}

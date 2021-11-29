package lotto.application;

import lotto.domain.LottoTickets;
import lotto.domain.Price;

public class AllAutomaticLottoTicketStrategy implements GenerateLottoTicketStrategy {

    @Override
    public LottoTickets publishTickets(Price price) {
        return LottoTickets.publishTickets(price);
    }
}

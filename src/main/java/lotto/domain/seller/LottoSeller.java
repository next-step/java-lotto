package lotto.domain.seller;

import lotto.domain.price.Price;
import lotto.domain.number.LottoNumbers;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoSeller of() {
        return new LottoSeller();
    }

    public LottoTickets buyTicket(final Price price) {
        validatePrice(price);

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < price.ticketCount(); i++) {
            tickets.add(LottoTicket.of(LottoNumbers.auto()));
        }
        return LottoTickets.of(tickets);
    }

    private void validatePrice(final Price price) {
        price.validateAvailablePrice();
    }
}

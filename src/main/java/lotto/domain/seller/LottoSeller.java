package lotto.domain.seller;

import lotto.domain.price.Price;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.AvailableCountExceedException;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoSeller newInstance() {
        return new LottoSeller();
    }

    public LottoTickets buyTicket(final Price price, final LottoTickets manualTickets) {
        verifyAvailableCount(price, manualTickets.count());
        return null;
    }

    private static void verifyAvailableCount(final Price price, final int manualTicketCount) {
        if (price.ticketCount() < manualTicketCount) {
            throw new AvailableCountExceedException();
        }
    }
}

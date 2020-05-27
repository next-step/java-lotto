package lotto.domain.seller;

import lotto.domain.number.LottoNumbers;
import lotto.domain.price.Price;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.AvailableCountExceedException;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoSeller newInstance() {
        return new LottoSeller();
    }

    public LottoTickets buyTicket(final Price price, final LottoTickets manualTickets) {
        verifyAvailableCount(price, manualTickets.count());

        LottoTickets autoTickets = LottoTickets.of(
                Stream.generate(LottoNumbers::autoCreate)
                    .limit(price.ticketCount() - manualTickets.count())
                    .map(LottoTicket::of)
                    .collect(Collectors.toList())
        );
        return manualTickets.merged(autoTickets);
    }

    private static void verifyAvailableCount(final Price price, final int manualTicketCount) {
        if (price.isExceedCount(manualTicketCount)) {
            throw new AvailableCountExceedException();
        }
    }
}

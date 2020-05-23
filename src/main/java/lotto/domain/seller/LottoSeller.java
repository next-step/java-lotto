package lotto.domain.seller;

import lotto.domain.number.LottoNumbers;
import lotto.domain.price.Price;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {

    private LottoSeller() {
    }

    public static LottoSeller newInstance() {
        return new LottoSeller();
    }

    public LottoTickets buyTicket(final Price price) {
        validatePrice(price);

        List<LottoTicket> tickets = Stream.generate(LottoNumbers::auto)
                .limit(price.ticketCount())
                .map(LottoTicket::of)
                .collect(Collectors.toList());
        return LottoTickets.of(tickets);
    }

    private void validatePrice(final Price price) {
        price.validateAvailablePrice();
    }
}

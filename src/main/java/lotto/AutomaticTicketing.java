package lotto;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domains.Purchase;
import lotto.domains.Ticket;
import lotto.domains.Tickets;
import lotto.strategy.LottoNumbers;

public class AutomaticTicketing {

    private LottoNumbers lottoNumbers;

    public AutomaticTicketing(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Ticket newTicket() {
        return new Ticket(lottoNumbers.choose());
    }

    public Tickets newTickets(Purchase purchase) {
        return Stream.generate(this::newTicket)
            .limit(purchase.automatedAmount())
            .collect(Collectors.collectingAndThen(Collectors.toList(), Tickets::new));
    }

}

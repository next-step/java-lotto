package lotto;

import lotto.common.PositiveNumber;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;

public class MockLottoTicketGenerator implements LottoTicketGenerator {

    private final LottoTickets lottoTickets;

    MockLottoTicketGenerator(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public LottoTickets generate(PositiveNumber ticketCount) {
        return lottoTickets;
    }
}

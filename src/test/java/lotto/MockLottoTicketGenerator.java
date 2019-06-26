package lotto;

import lotto.domain.PurchaseAmount;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;

public class MockLottoTicketGenerator implements LottoTicketGenerator {

    private final LottoTickets lottoTickets;

    MockLottoTicketGenerator(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public LottoTickets generate(PurchaseAmount purchaseAmount) {
        return lottoTickets;
    }
}

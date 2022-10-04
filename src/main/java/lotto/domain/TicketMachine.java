package lotto.domain;

import lotto.domain.entity.LottoTicket;

public class TicketMachine {

    public LottoTicket createLottoTicket(NumberGenerationStrategy strategy) {
        return new LottoTicket(strategy.getNumbers());
    }
}

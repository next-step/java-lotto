package lotto.dto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.strategy.LottoTicketCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {
    public LottoTicket createTicket(LottoTicketCreateStrategy createStrategy) {
        return LottoTicket.of(createStrategy);
    }

    public LottoTickets createTickets(int ticketCount, LottoTicketCreateStrategy createStrategy) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(createTicket(createStrategy));
        }
        return new LottoTickets(lottoTickets);
    }

}

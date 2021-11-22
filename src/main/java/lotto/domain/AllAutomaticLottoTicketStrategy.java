package lotto.domain;

import lotto.domain.value.LottoTicket;
import lotto.domain.value.TicketCount;
import lotto.utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class AllAutomaticLottoTicketStrategy implements GenerateLottoTicketStrategy {

    public AllAutomaticLottoTicketStrategy() {
    }

    @Override
    public List<LottoTicket> publishTickets(TicketCount ticketCount) {
        int ticketSize = ticketCount.size();
        List<LottoTicket> lottoTickets = new ArrayList<>(ticketSize);

        for (int i = 0; i < ticketSize; i++) {
            lottoTickets.add(createTicket());
        }

        return lottoTickets;
    }

    private LottoTicket createTicket() {
        return LottoTicket.createTicket(
                LottoNumberGenerator.generateLottoNumbers());
    }
}

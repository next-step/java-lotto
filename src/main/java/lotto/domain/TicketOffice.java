package lotto.domain;

import java.util.ArrayList;

public class TicketOffice {
    private final LottoTicketPrice lottoTicketPrice;

    public TicketOffice(LottoTicketPrice lottoTicketPrice) {
        this.lottoTicketPrice = lottoTicketPrice;
    }

    public LottoTickets totalTickets(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
        LottoTickets allLottoTickets = new LottoTickets(new ArrayList<>());

        manualLottoTickets.lottoTickets()
                .forEach(allLottoTickets::add);

        autoLottoTickets.lottoTickets()
                .forEach(allLottoTickets::add);

        return allLottoTickets;
    }
}

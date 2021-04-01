package lotto.domain;

import java.util.ArrayList;

public class TicketOffice {
    private final LottoTicketPrice lottoTicketPrice;

    public TicketOffice(LottoTicketPrice lottoTicketPrice) {
        this.lottoTicketPrice = lottoTicketPrice;
    }

    public LottoTickets sale(NumberOfTicket numberOfTicket) {
        LottoTickets lottoTickets = new LottoTickets(new ArrayList<>());

        for (int i = 0; i < numberOfTicket.numberOfTicket(); i++) {
            lottoTickets.add(new LottoTicket(new LottoNumbers()));
        }

        return lottoTickets;
    }

    public LottoTicketPrice lottoTicketPrice() {
        return lottoTicketPrice;
    }
}

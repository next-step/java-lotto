package lotto.domain;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketOffice that = (TicketOffice) o;
        return Objects.equals(lottoTicketPrice, that.lottoTicketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicketPrice);
    }
}

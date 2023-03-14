package lotto;

import java.util.List;

public class ManyTickets {
    private List<LottoTicket> manyTickets;


    public ManyTickets(List<LottoTicket> manyTickets) {
        this.manyTickets = manyTickets;

    }

    public List<LottoTicket> getManyTickets() {
        return manyTickets;
    }
}

package lotto;

import java.util.List;

public class LottoBundle {

    private List<LottoNumbers> tickets;

    public LottoBundle(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public int count() {
        return tickets.size();
    }
}

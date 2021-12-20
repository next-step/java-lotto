package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    private final int price;

    LottoTickets(List<LottoTicket> lottoTickets, int price) {
        this.lottoTickets = lottoTickets;
        this.price = price;
    }
    
    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public double getPrice() {
        return this.price;
    }
}

package lotto_second.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public Lotto get(int index) {
        return lottoTickets.get(index);
    }

}

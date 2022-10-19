package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets;

    public LottoTickets(int lottoCount) {
        this.tickets = create(lottoCount);
    }

    private List<Lotto> create(int lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}

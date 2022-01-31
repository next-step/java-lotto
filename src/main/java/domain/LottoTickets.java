package domain;

import java.util.*;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public void addLottoTicket(Lotto lotto) {
        lottoTickets.add(lotto);
    }

}

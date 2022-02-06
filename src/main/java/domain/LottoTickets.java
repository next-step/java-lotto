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

    public void readyLottoTicket(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            addLottoTicket(new Lotto());
        }
    }

}

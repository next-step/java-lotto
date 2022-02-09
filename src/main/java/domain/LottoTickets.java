package domain;

import java.util.*;

public class LottoTickets {
    private final List<Lotto> lottos;

    public LottoTickets() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void addLottoTicket(Lotto lotto) {
        lottos.add(lotto);
    }

    public void readyLottoTicket(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            addLottoTicket(new Lotto());
        }
    }

}

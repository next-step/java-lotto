package step5.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoTicket> lottoTickets;

    public Lotto(LottoCount lottoCount) {
        lottoTickets = new ArrayList<>();
        createLottoTickets(lottoCount);
    }

    public void createLottoTickets(LottoCount lottoCount) {
        for (int i = 0; i < lottoCount.getLottoCount(); i++) {
            this.lottoTickets.add(new LottoTicket());
        }
    }

    public int size() {
        return this.lottoTickets.size();
    }

    public LottoTicket getLottoTicket(int index) {
        return this.lottoTickets.get(index);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}

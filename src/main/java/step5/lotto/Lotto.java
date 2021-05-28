package step5.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoTicket> lottoTickets;
    private final LottoCount lottoCount;

    public Lotto(int purchasePrice) {
        lottoTickets = new ArrayList<>();
        lottoCount = new LottoCount(purchasePrice);
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

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int getLottoCount() {
        return lottoCount.getLottoCount();
    }

    public int getPurchasePrice() {
        return lottoCount.calculateCountToPrice();
    }
}

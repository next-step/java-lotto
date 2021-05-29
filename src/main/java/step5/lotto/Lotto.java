package step5.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<LottoTicket> lottoTickets;
    private final LottoCount lottoCount;

    public Lotto(int purchasePrice, int manualCount) {
        lottoTickets = new ArrayList<>();
        lottoCount = new LottoCount(purchasePrice, manualCount);
    }

    public void addManualLottoTicket(Set<Integer> manualTickets) {
        LottoTicket manualLottoTicket = new LottoTicket();
        manualLottoTicket.createManualLottoNumbers(manualTickets);
        this.lottoTickets.add(manualLottoTicket);
    }

    public void addAutoLottoTicket() {
        for (int i = 0; i < lottoCount.autoLottoCount(); i++) {
            LottoTicket autoLottoTicket = new LottoTicket();
            autoLottoTicket.createAutoLottoNumbers();
            this.lottoTickets.add(autoLottoTicket);
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public int getPurchasePrice() {
        return lottoCount.calculateCountToPrice();
    }
}

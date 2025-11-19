package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets create(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.from(LottoNumberGenerator.generate()));
        }
        return new LottoTickets(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}

package lotto.service;

import lotto.domain.LottoStore;
import lotto.domain.LottoTickets;
import lotto.ui.LottoRequest;

public class LottoService {

    public LottoTickets buyLotto(final LottoRequest request) {
        LottoStore store = new LottoStore();
        return store.buyLotto(request);
    }
}

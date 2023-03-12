package lotto.service;

import lotto.domain.LottoStore;
import lotto.domain.LottoTicketList;
import lotto.ui.LottoBuyingRequest;

public class LottoService {

    public LottoTicketList buyLotto(final LottoBuyingRequest request) {
        LottoStore store = new LottoStore();
        return store.buyLotto(request);
    }
}

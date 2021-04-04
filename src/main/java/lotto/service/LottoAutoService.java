package lotto.service;

import lotto.domain.LottoTicket;

public class LottoAutoService {

    public LottoTicket purchaseLottoTicket(int purchaseCount) {
        return new LottoTicket(purchaseCount);
    }

}

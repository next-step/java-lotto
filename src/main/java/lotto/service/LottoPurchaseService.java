package lotto.service;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTickets;

public class LottoPurchaseService {

    public LottoTickets purchaseTickets(LottoMoney purchaseAmount) {
        return LottoTickets.autoTickets(purchaseAmount.purchaseCount());
    }
}

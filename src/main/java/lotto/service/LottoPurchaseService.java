package lotto.service;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTickets;

public class LottoPurchaseService {

    public LottoTickets purchaseTickets(int purchaseAmount) {
        LottoMoney lottoMoney = LottoMoney.of(purchaseAmount);
        return LottoTickets.autoTickets(lottoMoney.purchaseCount());
    }
}

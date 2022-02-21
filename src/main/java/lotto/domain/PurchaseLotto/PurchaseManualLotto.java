package lotto.domain.PurchaseLotto;

import lotto.domain.LottoTicket;

public class PurchaseManualLotto implements PurchaseLottoStrategy {

    public LottoTicket purchaseLotto(int price) {
        return LottoTicket.create();
    }
}

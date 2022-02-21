package lotto.domain.PurchaseLotto;

import lotto.domain.LottoTicket;

public class PurchaseAutoLotto implements PurchaseLottoStrategy {

    public LottoTicket purchaseLotto(int price) {
        return LottoTicket.create();
    }
}

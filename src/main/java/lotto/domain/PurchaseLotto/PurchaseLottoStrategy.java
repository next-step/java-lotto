package lotto.domain.PurchaseLotto;

import lotto.domain.LottoTicket;

public interface PurchaseLottoStrategy {

    public LottoTicket purchaseLotto(int price);
}
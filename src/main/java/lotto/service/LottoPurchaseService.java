package lotto.service;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTickets;

public class LottoPurchaseService {

    public void validatePurchasable(LottoMoney havingAmount, LottoMoney purchaseAmount) {
        havingAmount.validatePurchasable();
        if (havingAmount.compareTo(purchaseAmount) < 0) {
            throw new IllegalArgumentException("금액이 부족합니다. 보유금액과 구입금액을 확인해 주세요.");
        }
    }

    public LottoTickets purchaseAutoTickets(LottoMoney purchaseAmount) {
        return LottoTickets.autoTickets(purchaseAmount.purchaseCount());
    }
}

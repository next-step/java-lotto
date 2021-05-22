package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoPurchaseService {

    public LottoTickets purchaseTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int purchaseCount = purchaseAmount / LottoTicket.PRICE;
        return LottoTickets.autoTickets(purchaseCount);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LottoTicket.PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다. 최소 " + LottoTicket.PRICE + " 원 이상의 금액을 입력해 주세요.");
        }
    }
}

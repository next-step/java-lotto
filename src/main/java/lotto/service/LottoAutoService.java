package lotto.service;

import lotto.domain.LottoTicket;

public class LottoAutoService {

    private static final int LOTTO_PRICE = 1000;

    public LottoTicket purchaseLottoTicket(int purchaseAmount) {
        return new LottoTicket(calculateMaxPurchasableCount(purchaseAmount));
    }

    private int calculateMaxPurchasableCount(int purchaseAmount) {
        if(purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 1000원 이상의 금액을 입력해 주세요.");
        }
        return purchaseAmount / LOTTO_PRICE;
    }
}

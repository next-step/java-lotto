package lotto.service;

import lotto.domain.LottoConstant;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoManualService {

    public LottoTicket purchaseLottoTicket(int purchaseAmount, List<String> manualLottoPurchaseNumberList) {
        validatePurchasable(purchaseAmount, manualLottoPurchaseNumberList);
        return new LottoTicket(manualLottoPurchaseNumberList);
    }

    private void validatePurchasable(int purchaseAmount, List<String> manualLottoPurchaseNumberList) {
        if (purchaseAmount < manualLottoPurchaseNumberList.size() * LottoConstant.LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액이 부족합니다. 금액과 구매장수를 확인해 주세요.");
        }
    }
}

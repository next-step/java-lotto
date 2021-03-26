package lotto.service;

import lotto.domain.LottoConstant;
import lotto.domain.LottoRanks;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoAutoService {

    public LottoTicket purchaseLottoTicket(int purchaseAmount) {
        return new LottoTicket(calculateMaxPurchasableCount(purchaseAmount));
    }

    private int calculateMaxPurchasableCount(int purchaseAmount) {
        if(purchaseAmount < LottoConstant.LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 1000원 이상의 금액을 입력해 주세요.");
        }
        return purchaseAmount / LottoConstant.LOTTO_PRICE;
    }

    public LottoRanks inquiryWin(List<String> confirmTargetList, int[] winNumbers) {
        LottoTicket lottoTicket = new LottoTicket(confirmTargetList);
        return lottoTicket.inquiryRankList(winNumbers);
    }
}

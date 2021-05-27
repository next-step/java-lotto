package lotto.service;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

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

    public LottoTickets purchaseManualTickets(LottoMoney purchaseAmount, List<LottoNumbers> manualLottoNumbersList) {
        validatePurchasable(purchaseAmount, manualLottoNumbersList);
        List<LottoTicket> lottoTicketList = manualLottoNumbersList.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
        return new LottoTickets(lottoTicketList);
    }

    private void validatePurchasable(LottoMoney havingAmount, List<LottoNumbers> manualLottoNumbersList) {
        LottoMoney purchaseAmount = LottoMoney.fromCount(manualLottoNumbersList.size());
        validatePurchasable(havingAmount, purchaseAmount);
    }
}

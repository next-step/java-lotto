package lotto.controller;

import lotto.controller.dto.LottoPurchaseAssembler;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTickets;
import lotto.service.LottoPurchaseService;

public class LottoPurchaseController {

    private final LottoPurchaseService purchaseService;

    public LottoPurchaseController() {
        this.purchaseService = new LottoPurchaseService();
    }

    public LottoPurchaseResponse purchaseTickets(LottoPurchaseRequest request) {
        LottoMoney purchaseAmount = LottoMoney.of(request.getPurchaseAmount());
        LottoTickets lottoTickets = purchaseService.purchaseTickets(purchaseAmount);
        return LottoPurchaseAssembler.assemblePurchaseResponse(lottoTickets);
    }

}

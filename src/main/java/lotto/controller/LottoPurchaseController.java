package lotto.controller;

import lotto.controller.dto.LottoPurchaseAssembler;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.domain.LottoTickets;
import lotto.service.LottoPurchaseService;

public class LottoPurchaseController {

    private final LottoPurchaseService purchaseService;

    public LottoPurchaseController() {
        this.purchaseService = new LottoPurchaseService();
    }

    public LottoPurchaseResponse purchaseTickets(LottoPurchaseRequest request) {
        LottoTickets lottoTickets = purchaseService.purchaseTickets(request.getPurchaseAmount());
        return LottoPurchaseAssembler.assemblePurchaseResponse(lottoTickets);
    }

}

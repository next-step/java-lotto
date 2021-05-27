package lotto.controller;

import lotto.controller.dto.LottoNumbersAssembler;
import lotto.controller.dto.LottoPurchaseAssembler;
import lotto.controller.dto.LottoPurchaseRequest;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.service.LottoPurchaseService;

import java.util.List;

public class LottoPurchaseController {

    private final LottoPurchaseService purchaseService;

    public LottoPurchaseController() {
        this.purchaseService = new LottoPurchaseService();
    }

    public void validatePurchasable(LottoPurchaseRequest request) {
        LottoMoney havingAmount = LottoMoney.of(request.getPurchaseAmount());
        LottoMoney purchaseAmount = LottoMoney.fromCount(request.getManualLottoTicketCount());
        purchaseService.validatePurchasable(havingAmount, purchaseAmount);
    }

    public LottoPurchaseResponse purchaseTickets(LottoPurchaseRequest request) {
        LottoMoney manualTicketPurchaseAmount = LottoMoney.fromCount(request.getManualLottoTicketCount());
        List<LottoNumbers> manualLottoNumbersList = LottoNumbersAssembler.assembleLottoNumbersList(request.getManualLottoNumbers());
        LottoTickets manualTickets = purchaseService.purchaseManualTickets(manualTicketPurchaseAmount, manualLottoNumbersList);

        LottoMoney autoTicketPurchaseAmount = LottoMoney.of(request.getPurchaseAmount()).subtract(manualTicketPurchaseAmount);
        LottoTickets autoTickets = purchaseService.purchaseAutoTickets(autoTicketPurchaseAmount);

        return LottoPurchaseAssembler.assemblePurchaseResponse(manualTickets, autoTickets);
    }

}

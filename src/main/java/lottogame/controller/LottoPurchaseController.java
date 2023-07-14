package lottogame.controller;

import java.util.List;
import lottogame.controller.spi.PurchaseInputer;
import lottogame.controller.spi.PurchaseViewer;
import lottogame.domain.LottoTicket;
import lottogame.domain.spi.NumberGenerator;
import lottogame.service.LottoService;

public class LottoPurchaseController {

    private final PurchaseInputer purchaseInputer;
    private final PurchaseViewer purchaseViewer;
    private final LottoService lottoService;

    public LottoPurchaseController(PurchaseInputer purchaseInputer, PurchaseViewer purchaseViewer,
        LottoService lottoService) {
        this.purchaseInputer = purchaseInputer;
        this.purchaseViewer = purchaseViewer;
        this.lottoService = lottoService;
    }

    public List<LottoTicket> purchaseLottoTickets(NumberGenerator numberGenerator) {
        int money = purchaseInputer.inputMoney();
        List<LottoTicket> lottoTickets = lottoService.purchase(money, numberGenerator);
        purchaseViewer.draw(lottoTickets);
        return lottoTickets;
    }
}

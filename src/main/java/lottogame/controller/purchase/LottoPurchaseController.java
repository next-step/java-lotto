package lottogame.controller.purchase;

import java.util.List;
import lottogame.controller.purchase.spi.PurchaseInputer;
import lottogame.controller.purchase.spi.PurchaseViewer;
import lottogame.domain.LottoTicket;
import lottogame.service.LottoPurchaseService;

public class LottoPurchaseController {

    private final PurchaseInputer purchaseInputer;
    private final PurchaseViewer purchaseViewer;
    private final LottoPurchaseService lottoPurchaseService;

    public LottoPurchaseController(PurchaseInputer purchaseInputer, PurchaseViewer purchaseViewer,
        LottoPurchaseService lottoPurchaseService) {
        this.purchaseInputer = purchaseInputer;
        this.purchaseViewer = purchaseViewer;
        this.lottoPurchaseService = lottoPurchaseService;
    }

    public List<LottoTicket> purchaseLottoTickets() {
        int money = purchaseInputer.inputMoney();
        List<LottoTicket> lottoTickets = lottoPurchaseService.purchase(money);
        purchaseViewer.draw(lottoTickets);
        return lottoTickets;
    }
}

package lottogame.controller.purchase;

import java.util.List;
import lottogame.controller.purchase.spi.PurchaseInputer;
import lottogame.controller.purchase.spi.PurchaseViewer;
import lottogame.domain.LottoPurchaseManager;
import lottogame.domain.LottoTicket;

public class LottoPurchaseController {

    private final PurchaseInputer purchaseInputer;
    private final PurchaseViewer purchaseViewer;
    private final LottoPurchaseManager lottoPurchaseManager;

    public LottoPurchaseController(PurchaseInputer purchaseInputer, PurchaseViewer purchaseViewer,
        LottoPurchaseManager lottoPurchaseManager) {
        this.purchaseInputer = purchaseInputer;
        this.purchaseViewer = purchaseViewer;
        this.lottoPurchaseManager = lottoPurchaseManager;
    }

    public List<LottoTicket> purchaseLottoTickets() {
        int money = purchaseInputer.inputMoney();
        List<LottoTicket> lottoTickets = lottoPurchaseManager.purchase(money);
        purchaseViewer.draw(lottoTickets);
        return lottoTickets;
    }
}

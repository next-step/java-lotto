package lottogame.app;

import java.util.List;
import lottogame.console.purchase.ConsolePurchaseInputer;
import lottogame.console.purchase.ConsolePurchaseViewer;
import lottogame.console.resultcheck.ConsoleResultCheckInputer;
import lottogame.console.resultcheck.ConsoleResultCheckViewer;
import lottogame.controller.purchase.LottoPurchaseController;
import lottogame.controller.purchase.spi.PurchaseInputer;
import lottogame.controller.purchase.spi.PurchaseViewer;
import lottogame.controller.resultcheck.LottoResultCheckController;
import lottogame.controller.resultcheck.spi.ResultCheckInputer;
import lottogame.controller.resultcheck.spi.ResultCheckViewer;
import lottogame.domain.LottoTicket;
import lottogame.domain.spi.NumberGenerator;
import lottogame.randomnumber.RandomLottoNumberGenerator;
import lottogame.service.LottoCheckService;
import lottogame.service.LottoPurchaseService;

public class Application {

    public Application() {
        PurchaseInputer purchaseInputer = new ConsolePurchaseInputer();
        PurchaseViewer purchaseViewer = new ConsolePurchaseViewer();
        NumberGenerator numberGenerator = new RandomLottoNumberGenerator();
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(numberGenerator);
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(purchaseInputer, purchaseViewer,
            lottoPurchaseService);

        ResultCheckInputer resultCheckInputer = new ConsoleResultCheckInputer();
        ResultCheckViewer resultCheckViewer = new ConsoleResultCheckViewer();
        LottoCheckService lottoCheckService = new LottoCheckService();
        LottoResultCheckController lottoResultCheckController = new LottoResultCheckController(resultCheckInputer,
            resultCheckViewer, lottoCheckService);

        List<LottoTicket> lottoTickets = lottoPurchaseController.purchaseLottoTickets();
        lottoResultCheckController.checkResult(lottoTickets);
    }

    public static void main(String[] args) {
        new Application();
    }
}

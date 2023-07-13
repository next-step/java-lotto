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
import lottogame.randomnumber.RandomLottoNumberGenerator;
import lottogame.service.LottoCheckService;
import lottogame.service.LottoPurchaseService;

public class Application {

    private final LottoPurchaseController lottoPurchaseController;
    private final LottoResultCheckController lottoResultCheckController;

    private Application() {
        lottoPurchaseController = getLottoPurchaseController();
        lottoResultCheckController = getLottoResultCheckController();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private LottoResultCheckController getLottoResultCheckController() {
        ResultCheckInputer resultCheckInputer = new ConsoleResultCheckInputer();
        ResultCheckViewer resultCheckViewer = new ConsoleResultCheckViewer();
        LottoCheckService lottoCheckService = new LottoCheckService();
        return new LottoResultCheckController(resultCheckInputer, resultCheckViewer, lottoCheckService);
    }

    private LottoPurchaseController getLottoPurchaseController() {
        PurchaseInputer purchaseInputer = new ConsolePurchaseInputer();
        PurchaseViewer purchaseViewer = new ConsolePurchaseViewer();
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(new RandomLottoNumberGenerator());
        return new LottoPurchaseController(purchaseInputer, purchaseViewer, lottoPurchaseService);
    }

    private void run() {
        List<LottoTicket> lottoTickets = lottoPurchaseController.purchaseLottoTickets();
        lottoResultCheckController.checkResult(lottoTickets);
    }
}

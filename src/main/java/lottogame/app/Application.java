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
import lottogame.service.LottoService;
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
        LottoService lottoCheckService = new LottoService();
        return new LottoResultCheckController(resultCheckInputer, resultCheckViewer, lottoCheckService);
    }

    private LottoPurchaseController getLottoPurchaseController() {
        PurchaseInputer purchaseInputer = new ConsolePurchaseInputer();
        PurchaseViewer purchaseViewer = new ConsolePurchaseViewer();
        LottoService lottoService = new LottoService();
        return new LottoPurchaseController(purchaseInputer, purchaseViewer, lottoService);
    }

    private void run() {
        NumberGenerator numberGenerator = new RandomLottoNumberGenerator();
        List<LottoTicket> lottoTickets = lottoPurchaseController.purchaseLottoTickets(numberGenerator);
        lottoResultCheckController.checkResult(lottoTickets);
    }
}

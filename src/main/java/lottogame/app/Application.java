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
import lottogame.domain.LottoCheckManager;
import lottogame.domain.LottoPurchaseManager;
import lottogame.domain.response.LottoTicketResponse;
import lottogame.randomnumber.RandomLottoNumberGenerator;

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
        LottoCheckManager lottoCheckManager = new LottoCheckManager(null, 0);
        return new LottoResultCheckController(resultCheckInputer, resultCheckViewer, lottoCheckManager);
    }

    private LottoPurchaseController getLottoPurchaseController() {
        PurchaseInputer purchaseInputer = new ConsolePurchaseInputer();
        PurchaseViewer purchaseViewer = new ConsolePurchaseViewer();
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(new RandomLottoNumberGenerator());
        return new LottoPurchaseController(purchaseInputer, purchaseViewer, lottoPurchaseManager);
    }

    private void run() {
        List<LottoTicketResponse> lottoTicketRespones = lottoPurchaseController.purchaseLottoTickets();
        lottoResultCheckController.checkResult(null);
    }
}

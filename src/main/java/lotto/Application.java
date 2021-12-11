package lotto;

import lotto.controller.LottoGameController;
import lotto.controller.PurchaseLottosRequest;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        Lottos lottos = lottoGameController.purchaseLottos(PurchaseLottosRequest.from(InputView.readPurchasingAmount()));
        OutputView.printPurchasedLottoInformation(lottos);
        OutputView.printStatisticsForLottos(lottoGameController.retrieveStatistics(lottos, InputView.readWinningLottoNumbers()));
    }
}

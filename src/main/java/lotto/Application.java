package lotto;

import lotto.controller.LottoGameController;
import lotto.controller.PurchaseLottosRequest;
import lotto.controller.RetrieveStatisticsRequest;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        int purchasingPrice = InputView.readPurchasingAmount();
        int manualPurchasingSize = InputView.readManualPurchasingSize();
        Lottos lottos = lottoGameController.purchaseLottos(
                PurchaseLottosRequest.of(purchasingPrice, InputView.readManualPurchasingLotto(manualPurchasingSize))
        );
        OutputView.printPurchasedLottoInformation(lottos, manualPurchasingSize);
        OutputView.printStatisticsForLottos(
                lottoGameController.retrieveStatistics(
                        RetrieveStatisticsRequest.of(lottos, InputView.readWinningLottoNumbers(), InputView.readBonusLottoNumber())
                )
        );
    }
}

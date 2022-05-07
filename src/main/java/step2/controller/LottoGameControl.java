package step2.controller;

import step2.domain.*;
import step2.service.LottoGameService;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoGameControl {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGameControl() {
        this(new InputView(), new ResultView());
    }

    public LottoGameControl(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        PurchaseMount purchaseMount = new PurchaseMount(inputView.inputMoney());
        int manualCount = inputView.manualCount();
        int autoCount = purchaseMount.mount() - manualCount;
        List<String> manualPick = inputView.manualPick(manualCount);
        inputView.resultPurchase(manualCount, autoCount);

        Lottos lottos = new Lottos(manualPick, autoCount);
        resultView.lottoCount(lottos.size());
        for (int i = 0; i < lottos.size(); i++) {
            resultView.displayLottoNumber(lottos.numbers(i));
        }

        LottoGameService lottoGameService =
                new LottoGameService(inputView.lottoNumbers(), inputView.bonusBall());
        LottoWinners winners = lottoGameService.match(lottos);
        double rate = lottoGameService.moneyProfitRate(purchaseMount.money(), winners);

        resultView.display(winners, rate);
    }
}

package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

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
        PurchaseLotto purchaseLotto = new PurchaseLotto(inputView.inputMoney());
        purchaseLotto.update(inputView.manualPick());
        inputView.resultPurchase(purchaseLotto);

        Lottos lottos = new Lottos(purchaseLotto);
        resultView.lottoPick(lottos);

        LottoWeeklyNumber lottoWeeklyNumber =
                new LottoWeeklyNumber(inputView.lottoNumbers(), inputView.bonusBall());
        LottoWinners winner = lottos.match(lottoWeeklyNumber);

        resultView.display(winner, purchaseLotto.getMoney());
    }
}

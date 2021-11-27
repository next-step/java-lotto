package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startLottoGame() {
        Money money = inputView.inputMoney();
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        Store store = new Store();
        Lotties lotties = store.purchaseLottiesByMoney(money, numberGenerator);
        resultView.purchaseLottiesInformation(lotties);
        Lotto lastWeekWinLotto = inputView.inputLastWeekWinLotto();
        LottoGameResult lottoGameResult = new LottoGameResult(lotties, lastWeekWinLotto);
        resultView.printGameResult(lottoGameResult);
    }
}

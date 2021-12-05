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
        Money money = new Money(inputView.inputMoney());
        LottoGenerator numberGenerator = new RandomLottoGenerator();
        Store store = new Store();
        Lotties lotties = store.purchaseLottiesByMoney(money, numberGenerator);
        resultView.purchaseLottiesInformation(lotties);
        Lotto lastWeekWinLotto = Lotto.from(inputView.inputLastWeekWinLotto());
        LottoNumber bonusNumber = new LottoNumber(inputView.bonusBall());
        WinLotto winLotto = new WinLotto(lastWeekWinLotto, bonusNumber);
        ResultRank resultRank = lotties.gameResultRank(winLotto);
        resultView.printGameResult(resultRank, lotties.getLottiesPrice());
    }
}

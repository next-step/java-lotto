package lotto.business;

import lotto.objects.Lotto;
import lotto.objects.Lottos;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class RunLotto {
    private static InputView inputView;
    private static ResultView resultView;
    private static PlayLotto playLotto;

    public RunLotto() {
        inputView = new InputView();
        resultView = new ResultView();
        playLotto = new PlayLotto();
    }

    public void runLotto() {
        Lottos createdLottos;
        Lotto lastWinningLotto = new Lotto();

        int money = inputView.enterPurchaseMoney();
        int totalLotto = playLotto.buyLotto(money);

        createdLottos = resultView.showCreatedLottos(totalLotto);

        inputView.enterLastWeekWinningNumbers(lastWinningLotto);
        inputView.enterBonusBallNumber(lastWinningLotto);

        resultView.showWinningStatistics(createdLottos, lastWinningLotto, money);

    }
}

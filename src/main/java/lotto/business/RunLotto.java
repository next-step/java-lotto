package lotto.business;

import lotto.objects.Lotto;
import lotto.objects.Lottos;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class RunLotto {
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();
    private static PlayLotto playLotto = new PlayLotto();

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

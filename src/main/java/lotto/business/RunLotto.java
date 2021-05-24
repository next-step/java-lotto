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
        int money = inputView.enterPurchaseMoney();
        int totalLotto = playLotto.buyLotto(money);

        Lottos createdLottos = playLotto.autoCreateLottos(totalLotto);

        resultView.showCreatedLottos(totalLotto, createdLottos);

        Lotto lastWinningLotto = inputView.enterLastWeekWinningNumbers();
        int bonusBallNumber = inputView.enterBonusBallNumber();

        resultView.showWinningStatistics(createdLottos, lastWinningLotto, money, bonusBallNumber);

    }
}

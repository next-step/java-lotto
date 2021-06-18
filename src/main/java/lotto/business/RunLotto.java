package lotto.business;

import lotto.objects.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class RunLotto {
    private static InputView inputView;
    private static ResultView resultView;

    public RunLotto() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void runLotto() {
        Money money = inputView.enterPurchaseMoney();

        Player player = new Player(money);
        int totalLotto = player.buy();

        LottoMachine lottoMachine = new LottoMachine(totalLotto);
        Lottos createdLottos = lottoMachine.autoCreateLottos();

        resultView.showCreatedLottos(lottoMachine, createdLottos);

        Lotto lastWinningLotto = inputView.enterLastWeekWinningNumbers();
        BonusBall bonusBall = inputView.enterBonusBallNumber();

        resultView.showWinningStatistics(createdLottos, lastWinningLotto, money, bonusBall);

    }
}

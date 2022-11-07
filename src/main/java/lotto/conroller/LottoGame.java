package lotto.conroller;

import lotto.domain.*;
import lotto.strategy.ManualNumberStrategy;
import lotto.view.ResultView;
import lotto.view.UserInput;

import java.util.Map;

public class LottoGame {

    public void runLottoGame() {
        Money money = new Money(UserInput.inputMoney());
        collectStatistics(money, buyLotto(money), getWinningLotto());
    }

    private Purchasing buyLotto(Money money) {
        Purchasing purchasing = new Purchasing(money);
        ResultView.printLottoCnt(purchasing.getLottoCnt());
        ResultView.printLottos(purchasing.getLottos());
        return purchasing;
    }

    private Lotto getWinningLotto() {
        String inputWinningLotto = UserInput.inputWinningLotto();
        return new Lotto(new ManualNumberStrategy(inputWinningLotto));
    }

    private void collectStatistics(Money money, Purchasing purchasing, Lotto winningLotto) {
        Statistics statistics = new Statistics(purchasing.getWinningResult(winningLotto));
        Map<WinningType, Integer> statisticsResult = statistics.getStatistics();
        ResultView.printResultMessage();
        ResultView.printStatistics(statisticsResult);
        ResultView.printRateOfReturn(statistics.getRateOfReturn(money));
    }

    public static void main(String[] args) {
        LottoGame customer = new LottoGame();
        customer.runLottoGame();
    }
}

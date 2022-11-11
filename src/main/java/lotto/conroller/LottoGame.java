package lotto.conroller;

import lotto.domain.*;
import lotto.view.ResultView;
import lotto.view.UserInput;

import java.util.Map;

public class LottoGame {

    public void runLottoGame() {
        Money money = UserInput.inputMoney();
        collectStatistics(money, getWinningResult(buyLotto(money)));
    }

    private Purchasing buyLotto(Money money) {
        Purchasing purchasing = new Purchasing(money);
        ResultView.printLottoCount(purchasing.getLottoCount());
        ResultView.printLottos(purchasing.getLottos());
        return purchasing;
    }

    private Map<WinningType, Integer> getWinningResult(Purchasing purchasing) {
        Lotto winningLotto = new Lotto(UserInput.inputWinningLotto());
        LottoNumber bonusBall = UserInput.inputBonusBall();
        return purchasing.getWinningResult(new WinningLotto(winningLotto, bonusBall));
    }

    private void collectStatistics(Money money, Map<WinningType, Integer> winningResult) {
        Statistics statistics = new Statistics(winningResult);
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

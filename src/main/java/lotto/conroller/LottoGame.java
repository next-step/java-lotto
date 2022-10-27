package lotto.conroller;

import lotto.domain.Lotto;
import lotto.domain.Purchasing;
import lotto.domain.Statistics;
import lotto.domain.WinnigType;
import lotto.strategy.ManualNumberStrategy;
import lotto.view.ResultView;
import lotto.view.UserInput;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public void buyLotto() {
        String inputMoney = UserInput.inputMoney();
        Purchasing purchasing = new Purchasing(inputMoney);
        ResultView.printLottoCnt(purchasing.getLottoCnt());
        ResultView.printLottos(purchasing.getLottoList());

        String inputWinnigLotto = UserInput.inputWinningLotto();
        Lotto winningLotto = new Lotto(new ManualNumberStrategy(inputWinnigLotto));

        collectStatistics(Integer.parseInt(inputMoney), purchasing, winningLotto);
    }

    private static void collectStatistics(int money, Purchasing purchasing, Lotto winningLotto) {
        List<Long> matchCntList =  purchasing.getMatchCntList(winningLotto);
        Statistics statistics = new Statistics();
        Map<WinnigType, Integer> statisticsMap = statistics.getStatistics(matchCntList);

        ResultView.printResultMent();
        ResultView.printStatistics(statisticsMap);
        ResultView.printRateOfReturn(statistics.getRateOfReturn(money));
    }

    public static void main(String[] args) {
        LottoGame customer = new LottoGame();
        customer.buyLotto();
    }
}

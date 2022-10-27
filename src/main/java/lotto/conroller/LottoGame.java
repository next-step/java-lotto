package lotto.conroller;

import lotto.domain.Lotto;
import lotto.domain.Purchasing;
import lotto.domain.Statistics;
import lotto.domain.WinnigType;
import lotto.strategy.RandomNumberStrategy;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public void buyLotto(int money) {
        Lotto winningLotto = new Lotto(new RandomNumberStrategy());
        Purchasing purchasing = new Purchasing(money);

        ResultView resultView = new ResultView();
        resultView.printLottoCnt(purchasing.getLottoCnt());
        resultView.printLottos(purchasing.getLottoList());

        List<Long> matchCntList =  purchasing.getMatchCntList(winningLotto);
        Statistics statistics = new Statistics();
        Map<WinnigType, Integer> statisticsMap = statistics.getStatistics(matchCntList);

        resultView.printResultMent();
        resultView.printStatistics(statisticsMap);
        resultView.printRateOfReturn(statistics.getRateOfReturn(money));
    }

    public static void main(String[] args) {
        LottoGame customer = new LottoGame();
        customer.buyLotto(31000);
    }
}

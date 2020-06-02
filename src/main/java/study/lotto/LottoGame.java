package study.lotto;

import study.lotto.model.Lotto;
import study.lotto.model.Lottos;
import study.lotto.model.Statistics;
import study.lotto.model.WinningLotto;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

public class LottoGame {

    public static void main(String[] args) {
        int totalPrice = InputView.scanTotalPrice();
        int numOfLottos = Lotto.calculateNumOfLottos(totalPrice);

        Lottos lottos = Lottos.of(numOfLottos);

        ResultView.printPurchaseMessage(numOfLottos, lottos);

        WinningLotto winningLotto = WinningLotto.of(InputView.scanWinningNumbers());

        Statistics statistics = new Statistics(lottos);
        statistics.calculateStatistics(winningLotto);

        ResultView.printStatisticsMessage(statistics, statistics.calculateEarningRate(totalPrice));
    }
}

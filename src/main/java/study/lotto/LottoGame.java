package study.lotto;

import study.lotto.model.Lotto;
import study.lotto.model.Lottos;
import study.lotto.model.Statistics;
import study.lotto.model.WinningLotto;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        int totalPrice = InputView.scanTotalPrice();
        int numOfLottos = Lotto.calculateNumOfLottos(totalPrice);
        int numOfManualLottos = InputView.scanNumOfManualLottos();

        Lottos lottos = Lottos.of(InputView.scanManualLottoNumbers(numOfManualLottos));

        int numOfAutoLottos = numOfLottos - numOfManualLottos;
        lottos.addAll(Lottos.of(numOfAutoLottos));

        ResultView.printPurchaseMessage(numOfManualLottos, numOfAutoLottos, lottos);

        WinningLotto winningLotto = WinningLotto.of(InputView.scanWinningNumbers());
        int bonusNumber = InputView.scanBonusNumber();

        Statistics statistics = new Statistics(lottos);
        statistics.calculateStatistics(winningLotto, bonusNumber);

        ResultView.printStatisticsMessage(statistics, statistics.calculateEarningRate(totalPrice));
    }
}

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
        int numOfManualLottos = InputView.scanNumOfManualLottos();

        Lottos manualLottos = null;

        if(numOfManualLottos > 0) {
            List<Lotto> lottoList = InputView.scanManualLottoNumbers(numOfManualLottos);
            manualLottos = Lottos.of(lottoList);
        }

        int manualLottosTotalPrice = Lotto.calculateTotalPrice(numOfManualLottos);
        int numOfAutoLottos = Lotto.calculateNumOfLottos(totalPrice - manualLottosTotalPrice);

        Lottos autoLottos = Lottos.of(numOfAutoLottos);

        Lottos lottos = Lottos.merge(manualLottos, autoLottos);

        ResultView.printPurchaseMessage(numOfManualLottos, numOfAutoLottos, lottos);

        WinningLotto winningLotto = WinningLotto.of(InputView.scanWinningNumbers());
        int bonusNumber = InputView.scanBonusNumber();

        Statistics statistics = new Statistics(lottos);
        statistics.calculateStatistics(winningLotto, bonusNumber);

        ResultView.printStatisticsMessage(statistics, statistics.calculateEarningRate(totalPrice));
    }
}

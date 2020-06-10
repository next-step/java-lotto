package study.lotto;

import study.lotto.helper.LottoHelper;
import study.lotto.model.Lottos;
import study.lotto.model.Statistics;
import study.lotto.model.WinningLottoInfo;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

public class LottoGame {

    public static void main(String[] args) {
        LottoHelper lottoHelper = new LottoHelper(InputView.scanPurchaseAmount());
        lottoHelper.setManualLottoCount(InputView.scanManualLottoCount());

        Lottos lottos = Lottos.of(InputView.scanManualLottoNumbers(lottoHelper.getManualLottoCount()));

        lottos.addAll(Lottos.of(lottoHelper.getAutoLottoCount()));

        ResultView.printPurchaseMessage(lottoHelper.getManualLottoCount(), lottoHelper.getAutoLottoCount(), lottos);

        WinningLottoInfo winningLottoInfo = WinningLottoInfo.of(InputView.scanWinningNumbers(), InputView.scanBonusNumber());

        Statistics statistics = new Statistics(lottos);
        statistics.calculateStatistics(winningLottoInfo);

        ResultView.printStatisticsMessage(statistics, statistics.calculateEarningRate(lottoHelper.getPurchaseAmount()));
    }
}

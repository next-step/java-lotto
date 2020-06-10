package study.lotto.service;

import study.lotto.helper.LottoHelper;
import study.lotto.model.LottoResult;
import study.lotto.model.Lottos;
import study.lotto.model.WinningLottoInfo;
import study.lotto.utils.StatisticUtils;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

public class LottoService {

    public Lottos purchaseLottos(LottoHelper lottoHelper) {
        Lottos lottos = purchaseManualLottos(lottoHelper.getManualLottoCount());

        lottos.addAll(purchaseAutoLottos(lottoHelper.getAutoLottoCount()));

        ResultView.printPurchaseMessage(
                lottoHelper.getManualLottoCount(),
                lottoHelper.getAutoLottoCount(),
                lottos
        );

        return lottos;
    }

    private Lottos purchaseManualLottos(int manualLottoCount) {
        return Lottos.of(InputView.scanManualLottoNumbers(manualLottoCount));
    }

    private Lottos purchaseAutoLottos(int autoLottoCount) {
        return Lottos.of(autoLottoCount);
    }

    public void checkLottoResult(Lottos lottos, LottoHelper lottoHelper) {
        WinningLottoInfo winningLottoInfo = WinningLottoInfo.of(InputView.scanWinningNumbers(), InputView.scanBonusNumber());

        LottoResult lottoResult = LottoResult.produce(lottos, winningLottoInfo);

        ResultView.printStatisticsMessage(lottoResult, StatisticUtils.calculateEarningRate(lottoHelper.getPurchaseAmount(), lottoResult));
    }
}

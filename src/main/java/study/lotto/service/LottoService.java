package study.lotto.service;

import study.lotto.domain.LottoResult;
import study.lotto.domain.Lottos;
import study.lotto.domain.LottoPurchase;
import study.lotto.domain.WinningLottoInfo;
import study.lotto.utils.StatisticUtils;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

public class LottoService {

    public Lottos purchaseLottos(LottoPurchase lottoPurchase) {
        Lottos lottos = purchaseManualLottos(lottoPurchase.getManualLottoCount());

        lottos.addAll(purchaseAutoLottos(lottoPurchase.getAutoLottoCount()));

        ResultView.printPurchaseMessage(
                lottoPurchase.getManualLottoCount(),
                lottoPurchase.getAutoLottoCount(),
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

    public void checkLottoResult(Lottos lottos, LottoPurchase lottoPurchase) {
        WinningLottoInfo winningLottoInfo = WinningLottoInfo.of(InputView.scanWinningNumbers(), InputView.scanBonusNumber());

        LottoResult lottoResult = LottoResult.produce(lottos, winningLottoInfo);

        ResultView.printStatisticsMessage(lottoResult, StatisticUtils.calculateEarningRate(lottoPurchase.getPurchaseAmount(), lottoResult));
    }
}

package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoTotalPrice;
import lotto.domain.LottoGroupResult;
import lotto.pattern.LottoNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final LottoNumberGenerateStrategy lottoNumberGenerateStrategy;

    public LottoController(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this.lottoNumberGenerateStrategy = lottoNumberGenerateStrategy;
    }

    public void autoLottoProgramStart() {
        LottoTotalPrice lottoTotalPrice = InputView.scanPurchaseAmount();

        int manualLottoCount = InputView.scanManualLottosCount(lottoTotalPrice);
        List<Lotto> manualLottos = InputView.scanManualLottos(manualLottoCount);

        int lottoCount = lottoTotalPrice.getPurchaseLottoCount();
        ResultView.printLottoCount(manualLottoCount, lottoCount - manualLottoCount);

        LottoGroup lottoGroup = LottoGroup.create(manualLottos, LottoGroup.createLottos(lottoCount - manualLottoCount, lottoNumberGenerateStrategy));
        ResultView.printLottoGroup(lottoGroup);

        WinningLotto winningLotto = InputView.getWinningLotto(InputView.scanWinningLotto());

        LottoGroupResult lottoGroupResult = lottoGroup.getLottoGroupResult(winningLotto);
        ResultView.printWinningStatistic(lottoGroupResult, lottoTotalPrice.getTotalPrice());
    }
}

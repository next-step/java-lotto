package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTotalPrice;
import lotto.domain.LottoGroupResult;
import lotto.pattern.LottoNumberGenerateStrategy;
import lotto.util.StringNumberUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final LottoNumberGenerateStrategy lottoNumberGenerateStrategy;

    public LottoController(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this.lottoNumberGenerateStrategy = lottoNumberGenerateStrategy;
    }

    public void autoLottoProgramStart() {
        LottoTotalPrice lottoPurchaseAmount = LottoTotalPrice.create(InputView.scanPurchaseAmount());

        int manualLottoCount = StringNumberUtils.parse(InputView.scanManualLottoCount());
        List<Lotto> manualLottos = InputView.scanManualLottos(manualLottoCount);

        int lottoCount = lottoPurchaseAmount.getPurchaseLottoCount();
        ResultView.printLottoCount(manualLottoCount, lottoCount - manualLottoCount);

        LottoGroup lottoGroup = LottoGroup.create(manualLottos, LottoGroup.createLottos(lottoCount - manualLottoCount, lottoNumberGenerateStrategy));
        ResultView.printLottoGroup(lottoGroup);

        Lotto winningNumbers = Lotto.create(InputView.scanWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.create(InputView.scanBonusNumber());

        LottoGroupResult lottoGroupResult = lottoGroup.getLottoGroupResult(new WinningLotto(winningNumbers, bonusNumber));
        ResultView.printWinningStatistic(lottoGroupResult, lottoPurchaseAmount.getTotalPrice());
    }
}

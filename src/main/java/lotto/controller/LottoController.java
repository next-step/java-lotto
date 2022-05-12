package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTotalPrice;
import lotto.domain.LottoGroupResult;
import lotto.pattern.LottoNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.Collectors;

public class LottoController {
    private final LottoNumberGenerateStrategy lottoNumberGenerateStrategy;

    public LottoController(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this.lottoNumberGenerateStrategy = lottoNumberGenerateStrategy;
    }

    public void autoLottoProgramStart() {
        LottoTotalPrice lottoPurchaseAmount = LottoTotalPrice.create(InputView.scanPurchaseAmount());
        int lottoCount = lottoPurchaseAmount.getPurchaseLottoCount();
        ResultView.printLottoCount(lottoCount);

        LottoGroup lottoGroup = new LottoGroup(lottoCount, lottoNumberGenerateStrategy);

        ResultView.printLottoGroup(lottoGroup);

        Lotto winningNumbers = new Lotto(InputView.scanWinningNumbers()
                .stream().map(LottoNumber::create).collect(Collectors.toList()));

        LottoNumber bonusNumber = LottoNumber.create(InputView.scanBonusNumber());

        LottoGroupResult lottoGroupResult = lottoGroup.getLottoGroupResult(new WinningLotto(winningNumbers, bonusNumber));
        ResultView.printWinningStatistic(lottoGroupResult, lottoPurchaseAmount.getTotalPrice());
    }
}

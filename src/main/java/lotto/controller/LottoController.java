package lotto.controller;

import lotto.domain.Lotto;
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
        LottoTotalPrice lottoPurchaseAmount = new LottoTotalPrice(InputView.scanPurchaseAmount());
        int lottoCount = lottoPurchaseAmount.getPurchaseLottoCount();
        ResultView.printLottoCount(lottoCount);

        LottoGroup lottoGroup = new LottoGroup(lottoCount, lottoNumberGenerateStrategy);

        ResultView.printLottoGroup(lottoGroup);

        Lotto winningNumbers = new Lotto(InputView.scanWinningNumbers()
                .stream().map(LottoNumber::new).collect(Collectors.toList()));
        LottoGroupResult lottoGroupResult = lottoGroup.getLottoGroupResult(winningNumbers);
        ResultView.printWinningStatistic(lottoGroupResult, lottoPurchaseAmount.getTotalPrice());
    }
}

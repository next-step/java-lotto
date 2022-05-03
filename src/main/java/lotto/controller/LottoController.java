package lotto.controller;

import lotto.Lotto;
import lotto.LottoGroup;
import lotto.LottoNumber;
import lotto.LottoTotalPrice;
import lotto.LottoGroupResult;
import lotto.pattern.LottoNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.Collectors;

public class LottoController {
    private final LottoNumberGenerateStrategy lottoNumberGenerateStrategy;

    public LottoController(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this.lottoNumberGenerateStrategy = lottoNumberGenerateStrategy;
    }

    public void autoLottoProgram() {
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

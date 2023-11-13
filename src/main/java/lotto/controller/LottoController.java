package lotto.controller;

import lotto.domain.*;
import lotto.domain.strategy.RandomLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();

        BuyingAmount buyingAmount = new BuyingAmount(inputView.inputAmount());
        ManualCount manualCount = new ManualCount(inputView.inputManualCount(), buyingAmount);
        Lottos manaulLottos = LottoSeller.salesManualLottos(inputView.inputManualNumbers(manualCount));
        Lottos autoLottos = LottoSeller.salesAutoLottos(new RandomLottoNumberStrategy(), buyingAmount.autoBuyingCount(manualCount));
        Lottos lottos = new Lottos(autoLottos, manaulLottos);

        resultView.reportBuying(buyingAmount.autoBuyingCount(manualCount),
                manualCount.count(),
                lottos);

        WinningLotto winningLotto = new WinningLotto(Lotto.from(inputView.winnerNumber()),
                LottoNumber.valueOf(inputView.inputBonusNumber()));

        WinningResults winningResults = new WinningResults(winningLotto.winningRank(lottos));

        resultView.reportStats(winningResults, buyingAmount);
    }

}

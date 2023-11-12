package lotto.controller;

import lotto.ManualCount;
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
        ManualCount manualCount = new ManualCount(inputView.inputManualCount());
        Lottos manaulLottos = new Lottos(inputView.inputManualNumbers(manualCount));
        Lottos autoLottos = new Lottos(new RandomLottoNumberStrategy(), buyingAmount.units(manualCount));
        Lottos lottos = new Lottos(autoLottos, manaulLottos);

        resultView.reportBuying(buyingAmount.units(manualCount),
                manualCount.count(),
                lottos);

        WinningLotto winningLotto = new WinningLotto(Lotto.from(inputView.winnerNumber()),
                new LottoNumber(inputView.inputBonusNumber()));

        WinningResults winningResults = new WinningResults(winningLotto.winningRank(lottos));

        resultView.reportStats(winningResults, buyingAmount);
    }

}

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
        Lottos lottos = new Lottos(new RandomLottoNumberStrategy(), buyingAmount.units(manualCount));
        LottoMachine lottoMachine = new LottoMachine(lottos, manaulLottos);

        resultView.reportBuying(buyingAmount.units(manualCount),
                manualCount.count(),
                lottoMachine.getLottoNumbers());

        WinningLotto winningLotto = new WinningLotto(Lotto.from(inputView.winnerNumber()),
                new LottoNumber(inputView.inputBonusNumber()));
        WinningResults winningResults = lottoMachine.report(winningLotto);

        resultView.reportStats(winningResults, buyingAmount);
    }

}

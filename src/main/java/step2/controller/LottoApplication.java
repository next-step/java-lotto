package step2.controller;

import step2.domain.lotto.*;
import step2.domain.statistics.Statistics;
import step2.view.InputManual;
import step2.view.InputPrice;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoApplication {
        private static final InputView inputView = new InputView();
        private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final InputPrice inputPrice = inputView.inputPrice();
        final InputManual inputManual = inputView.inputManual();

        final LottoMachine lottoMachine = new LottoMachine(inputPrice.getPrice(), inputManual.getManualAmount());

        final Lottos manualIssue = lottoMachine.manualIssue(inputManual.getManualLottoList());
        final Lottos automaticIssue = lottoMachine.automaticIssue();
        final Lottos allIssues = manualIssue.add(automaticIssue);

        outputView.printLottoPurchase(lottoMachine, allIssues);

        final LottoNumbers lastWinningNumbers = inputView.inputLastWinningNumbers();
        final LottoNumber bonusNumber = inputView.inputBonusNumber();
        final WinningLotto winningLotto = new WinningLotto(lastWinningNumbers, bonusNumber);

        final LottoGame lottoGame = new LottoGame(allIssues, winningLotto);
        final Statistics statistics = lottoGame.start();

        outputView.printResult(statistics);
    }

}

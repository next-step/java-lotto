package lotto.controller;

import lotto.domain.LottoShuffleGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class JavaLotto {

    private final InputView inputView;
    private final ResultView resultView;

    JavaLotto(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void playLotto() {

        int amount = inputView.inputPurchaseAmountGuide();

        Lottos lottos = Lottos.createLottos(amount, LottoShuffleGenerator.getLottoShuffleGenerator());

        resultView.NumberOfLotto(lottos.getNumberOfLotto());
        resultView.printPurchasedLottos(lottos);

        int prize = lottos.getWinningPrize(new WinningLotto(inputView.inputWinnerNumber(), inputView.inputBonusNumber()));

        resultView.printResult(lottos.calculateStatistic(prize));
        resultView.printProfit(lottos.calculateProfit(prize, amount));

    }

}

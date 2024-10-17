package lotto.controller;

import lotto.domain.LottoShuffleGenerator;
import lotto.domain.Lottos;
import lotto.domain.Prize;
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

        int prize = lottos.getWinningPrize(inputView.inputWinnerNumber());

        resultView.printResult(Prize.calculateStatistic(prize));
        resultView.printProfit(lottos.calculateProfit(prize, amount));

    }

}

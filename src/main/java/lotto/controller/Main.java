package lotto.controller;

import lotto.controller.strategy.GenerateStrategy;
import lotto.controller.strategy.RandomStrategy;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.utils.LottoCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int purchaseMoney = InputView.askPurchaseMoney();
        int numOfLottos = LottoCalculator.getNumOfLottos(purchaseMoney);
        ResultView.printNumOfLottos(numOfLottos);

        GenerateStrategy randomStrategy = RandomStrategy.getInstance();
        LottosGenerator generator = new LottosGenerator(numOfLottos, randomStrategy);

        Lottos lottos = generator.generateLottos();
        ResultView.printLottos(lottos);

        Lotto winningLotto = InputView.askWinningLotto();
        Result result = lottos.getResult(winningLotto);
        ResultView.printStatistics(result, purchaseMoney);
    }
}

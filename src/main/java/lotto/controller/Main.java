package lotto.controller;

import lotto.controller.strategy.GenerateStrategy;
import lotto.controller.strategy.RandomStrategy;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.utils.PurchaseCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int money = InputView.askPurchaseMoney();
        int numOfLottos = PurchaseCalculator.getNumOfLottos(money);
        ResultView.printNumOfLottos(numOfLottos);

        GenerateStrategy randomStrategy = RandomStrategy.getInstance();
        LottosGenerator generator = new LottosGenerator(numOfLottos, randomStrategy);

        Lottos lottos = generator.generateLottos();
        ResultView.printLottos(lottos);

        String winningLotto = InputView.askWinningLotto();
        ResultView.printResult(new Result(), 0.35);
    }
}

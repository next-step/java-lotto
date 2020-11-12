package lotto.controller;

import lotto.controller.strategy.GenerateStrategy;
import lotto.controller.strategy.RandomStrategy;
import lotto.domain.Lottos;
import lotto.utils.PurchaseCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    // FIXME: 컨트롤러는 System.out 을 ResultView 를 통해서 접근해서야 한다.
    public static void main(String[] args) {
        int money = InputView.askPurchaseMoney();
        int numOfLottos = PurchaseCalculator.getNumOfLottos(money);

        GenerateStrategy randomStrategy = RandomStrategy.getInstance();
        LottosGenerator generator = new LottosGenerator(numOfLottos, randomStrategy);

        Lottos lottos = generator.generateLottos();
        ResultView.printLottos(lottos);

        ResultView.printNumOfLottos(numOfLottos);

        String winningLotto = InputView.askWinningLotto();
        System.out.println(winningLotto);
    }
}

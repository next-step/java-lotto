package lotto;

import lotto.domain.Lottos;
import lotto.domain.Parser;
import lotto.view.InputView;
import lotto.view.ResultView;

public class UserInterface {
    public static void main(String[] args) {
        int money = Parser.numberParsing(InputView.purchaseMoney());
        ResultView.purchaseCount(money);
        Lottos lottos = new Lottos(money);
        ResultView.lottos(lottos);
        String winningNumber = InputView.winningNumber();
        System.out.println();
        ResultView.winningStaticsMessage();
        for (int count = 3; count <= 6; count++) {
            ResultView.winningStatics(count, lottos.winningCount(winningNumber, count));
        }
        ResultView.rateOfReturn(lottos.rateOfReturn(winningNumber));
    }
}

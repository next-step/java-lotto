package step3.domain;

import step3.View.InputView;
import step3.View.ResultView;

import java.util.List;

public class LottoGame {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        int purchasePrice = inputView.inputPurchasePrice();
        Lottos lottos = new Lottos(new Price(purchasePrice));
        resultView.printPurchase(lottos);
        for (Lotto lotto : lottos.getLottoList()) {
            resultView.printInteger(lotto);
        }

        String lastWinning = inputView.inputLastInteger();
        int bonus = inputView.inputBonus();
        WinningLotto winningLotto = new WinningLotto(lastWinning, bonus);
        LottoStatistic lottoStatistic = new LottoStatistic();
        Calculator calculator = new Calculator(lottoStatistic.statistic(lottos, winningLotto));
        resultView.printSameLotto(lottoStatistic.statistic(lottos, winningLotto));

        resultView.printBenefit(calculator, new Price(purchasePrice));
    }


}

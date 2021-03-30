package step2.View;

import step2.Domain.Lottos;
import step2.Domain.Money;
import step2.Domain.RandomLottoNumberGenerator;

public class LottoGame {

    private InputView inputView;
    private ResultView resultView;

    public LottoGame() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void start() {
        Money money = inputView.buyLotto();
        Lottos lottos = Lottos.of(new RandomLottoNumberGenerator(money));
        resultView.printPurchaseNumber(money);
        resultView.printLottoList(lottos);
        //resultView.printLottoStatistic(lottos, inputView.winningLotto(), purchaseManager);
    }
}

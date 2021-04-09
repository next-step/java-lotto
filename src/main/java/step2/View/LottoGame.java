package step2.View;

import step2.Domain.*;

public class LottoGame {

    private InputView inputView;
    private ResultView resultView;

    public LottoGame() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void start() {
        Money money = inputView.buyLotto();
        PurchasedLottoNumber manualBuyNumber = inputView.buyManualLotto();
        Money remainMoney =  money.remain(manualBuyNumber);
        Lottos manualLottos = Lottos.of(new ManualLottoGenerator(inputView.inputLottoNumbers(manualBuyNumber)));
        Lottos autoLottos = Lottos.of(new RandomLottoNumberGenerator(remainMoney));
        resultView.printPurchaseNumber(money);
        resultView.printLottoList(autoLottos);
        Profit profit = new Profit(money, autoLottos.makeStatistic(inputView.winningLotto()));
        resultView.printLottoStatistic(profit);
        resultView.printProfitRate(profit);
    }
}

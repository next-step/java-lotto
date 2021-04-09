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
        Lottos manualLottos = Lottos.of(new ManualLottoGenerator(inputView.inputLottoNumbers(manualBuyNumber)));
        //테스트
        resultView.printLottoList(manualLottos);
        Lottos autoLottos = Lottos.of(new RandomLottoNumberGenerator(money.remain(manualBuyNumber)));
        resultView.printPurchaseNumber(money);
        resultView.printLottoList(autoLottos);
        Profit profit = new Profit(money, autoLottos.makeStatistic(inputView.winningLotto()));
        resultView.printLottoStatistic(profit);
        resultView.printProfitRate(profit);
    }
}

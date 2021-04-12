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
        Money remainMoney = money.remain(manualBuyNumber);
        MergeGenerator mergeGenerator =
                new MergeGenerator(
                        new ManualLottoGenerator(inputView.inputLottoNumbers(manualBuyNumber))
                                , new RandomLottoNumberGenerator(remainMoney));
        Lottos lottos = Lottos.of(mergeGenerator);
        resultView.printPurchaseNumber(manualBuyNumber, new PurchasedLottoNumber(remainMoney));
        resultView.printLottoList(lottos);
        WinningLotto winningLotto = inputView.winningLotto();
        Profit profit = new Profit(money, lottos.makeStatistic(winningLotto));
        resultView.printLottoStatistic(profit);
        resultView.printProfitRate(profit);
    }
}

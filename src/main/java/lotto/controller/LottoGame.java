package lotto.controller;

import lotto.domain.*;
import lotto.dto.PurchaseCount;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startLottoGame() {
        Money money = new Money(inputView.inputMoney());
        List<String> manualLottiesPaper = inputView.inputChoiceLottoPurchase();

        LottoGenerator numberGenerator = new RandomLottoGenerator();
        Store store = new Store();

        Lotties lotties = store.purchaseManualLotto(manualLottiesPaper);
        money = money.minus(Store.LOTTO_ONE_GAME_PRICE * manualLottiesPaper.size());
        Lotties autoLotties = store.purchaseLottiesByMoney(money, numberGenerator);

        PurchaseCount purchaseCount = new PurchaseCount(lotties.purchaseLottiesCount(), autoLotties.purchaseLottiesCount());
        lotties.addLotties(autoLotties);

        resultView.purchaseLottiesInformation(purchaseCount, lotties);

        Lotto lastWeekWinLotto = Lotto.from(inputView.inputLastWeekWinLotto());
        LottoNumber bonusNumber = new LottoNumber(inputView.bonusBall());

        WinLotto winLotto = new WinLotto(lastWeekWinLotto, bonusNumber);
        ResultRank resultRank = lotties.gameResultRank(winLotto);

        resultView.printGameResult(resultRank, lotties.getLottiesPrice());
    }
}

package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoResult;
import lotto.domain.WinningLottoNumber;
import lotto.dto.ManuallyPurchasingLottoCount;
import lotto.dto.ManuallyPurchasingLottoNumber;
import lotto.dto.PurchaseMoney;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoApplication() {
        this.lottoInputView = new LottoInputView();
        this.lottoOutputView = new LottoOutputView();
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.run();
    }

    private void run() {
        PurchaseMoney purchaseMoney = lottoInputView.questionPurchaseMoney();
        LottoGames purchaseLottoGames = purchaseLottoGames(purchaseMoney);

        WinningLottoNumber winningLottoNumber = lottoInputView.questionLastPrizeNumber();
        winningLottoNumber = lottoInputView.questionBonusNumber(winningLottoNumber);

        LottoResult lottoResult = winningLottoNumber.decidePrize(purchaseLottoGames);

        lottoOutputView.printPrizeStatistics(lottoResult, purchaseMoney);
    }

    private LottoGames purchaseLottoGames(PurchaseMoney purchaseMoney) {
        LottoGames manualLottoGames = purchaseLottoGamesManually(purchaseMoney);
        LottoGames autoLottoGames = LottoGames.purchaseAuto(purchaseMoney);
        lottoOutputView.printLottoGamesSize(autoLottoGames, manualLottoGames);

        LottoGames mergedLottoGames = mergeAutoAndManualLottoGames(autoLottoGames, manualLottoGames);
        lottoOutputView.printLottoGame(mergedLottoGames);
        return mergedLottoGames;
    }

    private LottoGames purchaseLottoGamesManually(PurchaseMoney purchaseMoney) {
        ManuallyPurchasingLottoCount manuallyPurchasingLottoCount = lottoInputView.questionManualPurchasingCount();
        purchaseMoney.minus(manuallyPurchasingLottoCount);

        lottoInputView.questionManualPurchasingLottoNumber();
        List<LottoGame> lottoGames = new ArrayList<>();
        while (manuallyPurchasingLottoCount.remainBuyableManualLottoCount()) {
            ManuallyPurchasingLottoNumber manuallyPurchasingLottoNumber = lottoInputView.answerManualPurchasingLottoNumber();
            LottoGame lottoGame = LottoGame.createManual(manuallyPurchasingLottoNumber.getValue());
            lottoGames.add(lottoGame);
        }
        return new LottoGames(lottoGames);
    }

    private LottoGames mergeAutoAndManualLottoGames(LottoGames autoLottoGames, LottoGames manualLottoGames) {
        return autoLottoGames.merge(manualLottoGames);
    }
}

package lotto;

import lotto.domain.LottoGames;
import lotto.domain.LottoResult;
import lotto.domain.WinningLottoNumber;
import lotto.dto.PurchaseMoney;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoApplication {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoApplication() {
        lottoInputView = new LottoInputView();
        lottoOutputView = new LottoOutputView();
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
        LottoGames autoLottoGames = LottoGames.purchaseAuto(purchaseMoney);
        LottoGames manualLottoGames = lottoInputView.questionManualPurchasingLotto();
        lottoOutputView.printLottoGamesSize(autoLottoGames, manualLottoGames);

        LottoGames mergedLottoGames = mergeAutoAndManualLottoGames(autoLottoGames, manualLottoGames);
        lottoOutputView.printLottoGame(mergedLottoGames);
        return mergedLottoGames;
    }

    private LottoGames mergeAutoAndManualLottoGames(LottoGames autoLottoGames, LottoGames manualLottoGames) {
        return autoLottoGames.merge(manualLottoGames);
    }
}

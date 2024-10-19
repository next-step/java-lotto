package lottogame.controller;

import lottogame.domain.LottoGameService;
import lottogame.domain.lotto.LottoPurchase;
import lottogame.domain.lotto.WinningLotto;
import lottogame.ui.LottoInputView;
import lottogame.ui.LottoOutputView;

import java.util.List;

public class LottoGameController {
    public void run() {
        int buyAmount = LottoInputView.getBuyAmount();
        int manualLottoCount = LottoInputView.getBuyManualLottoCount();
        List<String> manualLottoNumbers = LottoInputView.getBuyManualLottoNumbers(manualLottoCount);

        LottoGameService gameService = new LottoGameService(buyAmount, manualLottoCount, manualLottoNumbers);

        printPurchaseInfo(gameService.getLottoPurchase());
        LottoOutputView.printLottos(gameService.getLottos());

        String winningNumbers = LottoInputView.getWinningNumbers();
        int bonusNumber = LottoInputView.getBonusNumber();

        WinningLotto winningLotto = gameService.createWinningLotto(winningNumbers, bonusNumber);

        LottoOutputView.printWinningStatistics(gameService.getWinningResults(winningLotto));
        LottoOutputView.printPrizeRate(gameService.calculatePrizeRate(winningLotto));
    }

    private void printPurchaseInfo(LottoPurchase lottoPurchase) {
        LottoOutputView.printPurchaseInfo(lottoPurchase.getManualCount(), lottoPurchase.getAutoCount());
    }
}

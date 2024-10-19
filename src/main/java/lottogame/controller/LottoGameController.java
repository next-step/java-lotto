package lottogame.controller;

import lottogame.domain.LottoGameService;
import lottogame.domain.lotto.LottoPurchase;
import lottogame.domain.lotto.WinningLotto;
import lottogame.ui.LottoInputView;
import lottogame.ui.LottoOutputView;

import java.util.List;

public class LottoGameController {
    public void run() {
        try {
            int buyAmount = LottoInputView.getBuyAmount();
            int manualLottoCount = LottoInputView.getBuyManualLottoCount();
            List<String> manualLottoNumbers = LottoInputView.getBuyManualLottoNumbers(manualLottoCount);

            LottoGameService lottoGameService = new LottoGameService(buyAmount, manualLottoCount, manualLottoNumbers);

            printPurchaseInfo(lottoGameService.getLottoPurchase());
            LottoOutputView.printLottos(lottoGameService.getLottos());

            String winningNumbers = LottoInputView.getWinningNumbers();
            int bonusNumber = LottoInputView.getBonusNumber();

            WinningLotto winningLotto = lottoGameService.createWinningLotto(winningNumbers, bonusNumber);

            LottoOutputView.printWinningStatistics(lottoGameService.calculateWinningResults(winningLotto));
            LottoOutputView.printPrizeRate(lottoGameService.calculatePrizeRate(winningLotto));
        } catch (Exception e) {
            System.out.println("잘못된 동작입니다.");
        }

    }

    private void printPurchaseInfo(LottoPurchase lottoPurchase) {
        LottoOutputView.printPurchaseInfo(lottoPurchase.getManualCount(), lottoPurchase.getAutoCount());
    }
}
